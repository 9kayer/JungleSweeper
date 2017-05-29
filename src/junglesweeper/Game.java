package junglesweeper;

import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.gameobjects.GameObject;
import junglesweeper.gameobjects.GameObjectFactory;
import junglesweeper.gameobjects.GameObjectsType;
import junglesweeper.grid.Grid;
import junglesweeper.grid.GridFactory;
import junglesweeper.grid.GridType;
import junglesweeper.simplegfx.SimpleGfxSensor;
import junglesweeper.simplegfx.controls.ControlType;
import junglesweeper.player.Player;
import junglesweeper.simplegfx.SimpleGfxPlayer;
import junglesweeper.simplegfx.controls.MoveKeyMap;
import junglesweeper.sensor.Sensor;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fabio on 26/05/2017.
 */
public class Game {

    private static final int DELAY = 1;

    private ArrayList<GameObject> gameObjectList;
    private ArrayList<Stack<GameObject>> stackArrayList;
    private CollisionDetector collisionDetector;
    private Sensor sensor;
    private Grid grid;
    private Player player;
    private MoveKeyMap keyMap;
    private Level level;
    private SimpleGfxSensor traps;

    public Game(GridType gridType, int cols, int rows) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        gameObjectList = new ArrayList<>();
        keyMap = new MoveKeyMap(ControlType.MODE_1);
        level = new Level();
        sensor = new Sensor(cols,rows,level);
        stackArrayList = new ArrayList<>();
        collisionDetector = new CollisionDetector();

    }

    public void init() {

        for (int i = 0; i < GameObjectsType.values().length; i++) {
            stackArrayList.add(new Stack<>());
        }

        grid.init();
        keyMap.init();
        sensor.init();

        createGameObjects(0);
        player = new SimpleGfxPlayer(grid, grid.makeGridPosition(0, 0), 3, collisionDetector);
        collisionDetector.init(player, gameObjectList);

        /* After Create the game Objects we print the number of traps around them */
        traps = new SimpleGfxSensor(sensor.getEnemys(player.getPos().getRow(), player.getPos().getCol()));

    }

    public void start() throws InterruptedException {
        for(int i = 1; i <= 2; i++ ) {
            while (!collisionDetector.isDoorOpen()) {

                if (keyMap.isMoving()) {
                    player.move(keyMap.getDirection());
                    traps.reWrite(sensor.getEnemys(player.getPos().getRow(), player.getPos().getCol()));
                    keyMap.stopMoving();
                }

                collisionDetector.collision();

                Thread.sleep(DELAY);

            }
            retrieveGameObjects();
            createGameObjects(i);
            player.reset();
            collisionDetector.closeDoor();
            collisionDetector.init(player, gameObjectList);
        }
    }

    public void createGameObjects(int i) {

        GameObject object;

        for (int col = 0; col < grid.getCols(); col++) {
            for (int row = 0; row < grid.getRows(); row++) {

                if (col == 0 && row == 0) {
                    continue;
                }
                if (level.getLevelMatrix(i)[col][row] == 0) {
                    continue;
                }
                object = GameObjectFactory.createNewGameObjects(row, col, grid, GameObjectsType.translateMapReference(level.getLevelMatrix(i)[col][row]), stackArrayList);
                object.setCollisionDetector(collisionDetector); // not necessary for rocks
                gameObjectList.add(object);

            }
        }
    }

    public void retrieveGameObjects() {

        for (GameObject object : gameObjectList) {
                switch (object.getType()) {
                    case KEY:
                        stackArrayList.get(0).push(object);
                        object.getGridPosition().hide();
                        break;
                    case PATH:
                        stackArrayList.get(1).push(object);
                        object.getGridPosition().hide();
                        break;
                    case ROCK:
                        stackArrayList.get(2).push(object);
                        object.getGridPosition().hide();
                        break;
                    case TIGER:
                        stackArrayList.get(3).push(object);
                        object.getGridPosition().hide();
                        break;
                    case DOOR:
                        stackArrayList.get(4).push(object);
                        object.getGridPosition().hide();
                        break;
                    default:
                        System.out.println("Fail on retrieveGameObjects()");
                }
            }
        }

    }
