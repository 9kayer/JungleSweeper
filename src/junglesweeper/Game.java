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
    private static final int FIRST_LEVEL = 0;

    private ArrayList<GameObject> gameObjectList;
    private ArrayList<Stack<GameObject>> stackArrayList;
    private CollisionDetector collisionDetector;
    private Sensor sensor;
    private Grid grid;
    private Player player;
    private MoveKeyMap keyMap;
    private SimpleGfxSensor traps;

    public Game(GridType gridType, int cols, int rows) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        gameObjectList = new ArrayList<>();
        keyMap = new MoveKeyMap(ControlType.MODE_1);
        sensor = new Sensor(cols, rows, FIRST_LEVEL);
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

        player = new SimpleGfxPlayer(grid.makeGridPosition(0, 0), 3, collisionDetector);

        // After Create the game Objects we print the number of traps around them
        traps = new SimpleGfxSensor(sensor.getEnemys(player.getPos().getRow(), player.getPos().getCol()));

    }

    public void start() throws InterruptedException {

        for (int i = 0; i < Level.NUM_LEVELS; i++) {

            createLevel(i);

            while (!collisionDetector.isDoorOpen()) {

                movePlayer();

                Thread.sleep(DELAY);

            }

        }

    }

    private void movePlayer() {

        if (keyMap.isMoving()) {
            player.move(keyMap.getDirection());
            traps.reWrite(sensor.getEnemys(player.getPos().getRow(), player.getPos().getCol()));
            keyMap.stopMoving();
        }

        collisionDetector.collision();

    }

    private void createLevel(int i) {

        // If create level 1 or above
        // - Collect created objects
        // - Reset the player
        // - Close the door
        if (i > 0) {
            retrieveGameObjects();

            player.reset();
            collisionDetector.closeDoor();
        }

        // Create the game objects
        createGameObjects(i);

        // Prepare the collision detector for execution
        collisionDetector.init(gameObjectList, player);

        // Update sensor
        sensor.updateLevel(i);
        sensor.init();

    }

    private void createGameObjects(int i) {

        for (int col = 0; col < grid.getCols(); col++) {
            for (int row = 0; row < grid.getRows(); row++) {

                if (col == 0 && row == 0) {
                    continue;
                }

                if (Level.getLevelMatrix(i)[col][row] == 0) {
                    continue;
                }

                gameObjectList.add(
                        GameObjectFactory.createNewGameObjects(row, col, grid, GameObjectsType.translateMapReference(Level.getLevelMatrix(i)[col][row]), stackArrayList)
                );

            }
        }
    }

    private void retrieveGameObjects() {

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

        gameObjectList.clear();

    }

}
