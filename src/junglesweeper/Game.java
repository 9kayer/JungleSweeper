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

    private CollisionDetector collisionDetector;
    private ArrayList<ArrayList> gameObjectList;
    private ArrayList<Stack<GameObject>> stackArrayList;
    private Grid grid;
    private Player player;
    private MoveKeyMap keyMap;
    private Level level;
    private Sensor sensor;
    private SimpleGfxSensor traps;

    public Game(GridType gridType, int cols, int rows) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        gameObjectList = new ArrayList<>();
        keyMap = new MoveKeyMap(ControlType.MODE_1);
        level = new Level();
        sensor = new Sensor(cols,rows,level);
        stackArrayList = new ArrayList<>();

    }

    public void init() {

        grid.init();
        keyMap.init();

        for (int i = 0; i < GameObjectsType.values().length; i++) {
            stackArrayList.add(new Stack<>());
        }

        sensor.init();

        initGameObjectList();
        createGameObjects(0);

    }

    public void start() throws InterruptedException {

        while (true) {

            if (keyMap.isMoving()) {
                player.move(keyMap.getDirection());
                traps.reWrite(sensor.getEnemys(player.getPos().getRow() , player.getPos().getCol()));
                keyMap.stopMoving();
            }

            collisionDetector.collision(player);

            Thread.sleep(DELAY);

        }

    }

    public void initGameObjectList() {

        for (int i = 0; i < grid.getCols(); i++) {
            gameObjectList.add(new ArrayList<GameObject>());
        }

        collisionDetector = new CollisionDetector(gameObjectList);
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
                gameObjectList.get(row).add(object);

            }
        }

        player = new SimpleGfxPlayer(grid, grid.makeGridPosition(0, 0), 3, collisionDetector);
    }

    public void retrieveGameObjects() {

        ArrayList<GameObject> arrayList;
        GameObject object;

        for (int i = 0; i < gameObjectList.size(); i++) {
            arrayList = gameObjectList.get(i);
            for (int j = 0; j < arrayList.size(); j++) {
                object = arrayList.get(j);
                switch (arrayList.get(j).getType()) {
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
                        System.out.println("Something went terribly wrong!");
                }
            }

            arrayList.clear();
        }
        /*After Create the game Objects we print the number of traps arround them */
        traps = new SimpleGfxSensor(sensor.getEnemys(player.getPos().getRow() , player.getPos().getCol()));

    }

}
