package junglesweeper;

import junglesweeper.collisiondetector.Collidable;
import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.gameobjects.*;
import junglesweeper.grid.Display;
import junglesweeper.grid.Grid;
import junglesweeper.grid.GridFactory;
import junglesweeper.grid.DisplayType;
import junglesweeper.simplegfx.SimpleGfxSensor;
import junglesweeper.simplegfx.controls.ControlType;
import junglesweeper.player.Player;
import junglesweeper.simplegfx.SimpleGfxPlayer;
import junglesweeper.simplegfx.controls.MoveKeyMap;
import junglesweeper.sensor.Sensor;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fabio on 26/05/2017.
 */
public class Game {

    private static final int DELAY = 1;
    private static final int FIRST_LEVEL = 0;
    private static final String PLAYER_IMAGE_PATH = "./assets/pictures/fff40.png";
    private static final String BACKGROUND_IMAGE_PATH = "./assets/pictures/back.png";
    private static final String SENSOR_IMAGE_PATH = "./assets/pictures/sensor.png";

    private ArrayList<GameObject> gameObjectList;
    private ArrayList<Stack<GameObject>> stackArrayList;
    private CollisionDetector collisionDetector;
    private Display display;
    private Sensor sensor;
    private Grid grid;
    private Player player;
    private MoveKeyMap keyMap;
    private SimpleGfxSensor traps;

    private Picture background;
    private Picture sensorBackground;

    public Game(DisplayType displayType, int cols, int rows) {

        display = GridFactory.makeDisplay(displayType,10);

        background = new Picture(10,10, BACKGROUND_IMAGE_PATH);
        sensorBackground = new Picture(32,35, SENSOR_IMAGE_PATH);
        grid = GridFactory.makeGrid(displayType, cols, rows);

        gameObjectList = new ArrayList<>();
        keyMap = new MoveKeyMap(ControlType.MODE_1);
        sensor = new Sensor(cols, rows, FIRST_LEVEL);
        stackArrayList = new ArrayList<>();
        collisionDetector = new CollisionDetector();

    }

    public void init() {
        background.draw();
        sensorBackground.draw();

        // Init the stacks for game object collection
        for (int i = 0; i < GameObjectsType.values().length; i++) {
            stackArrayList.add(new Stack<>());
        }

        // Load the keyboard handler
        keyMap.init();

        // Load the danger sensor
        sensor.init();

        // Start the player
        player = new SimpleGfxPlayer(grid.makeGridPosition(0, 0, PLAYER_IMAGE_PATH), 3, collisionDetector);

        // After Create the game Objects we print the number of traps around them
        traps = new SimpleGfxSensor(sensor.getEnemys(player.getPos().getRow(), player.getPos().getCol()));

    }

    public void start() throws InterruptedException {

        // Draw the grid
        grid.init();

        // Collidable to check
        Collidable object;

        // Level walkthrough
        for (int i = 0; i < Level.NUM_LEVELS; i++) {

            // Create the level
            createLevel(i);

            // Draw all the objects
            drawObjects();

            // While the goal is not completed
            while (player.isAlive()) {

                // Move player and check for collisions
                if ((object = movePlayer()) != null) {

                    if (object instanceof Tiger) {
                        i--;
                        break;
                    }

                    if (object instanceof Door && object.isActive()) {
                        break;
                    }

                }

                Thread.sleep(DELAY);

            }

        }

    }

    private Collidable movePlayer() {

        // If a key is being pressed
        if (keyMap.isMoving()) {
            // Move the player one cell at a time
            player.move(keyMap.getDirection());
            keyMap.stopMoving();

            // Update the danger sensor output
            traps.reWrite(sensor.getEnemys(player.getPos().getRow(), player.getPos().getCol()));

        }

        // Check collisions
        return collisionDetector.collision();

    }

    private void createLevel(int i) {
        // - Collect created objects
        // - Reset the player
        // - Close the door

        retrieveGameObjects();

        player.reset();
        collisionDetector.closeDoor();

        // Create the game objects
        createGameObjects(i);

        // Prepare the collision detector for execution
        collisionDetector.init(gameObjectList, player);

        // Update sensor
        sensor.updateLevel(i);
        sensor.init();

    }

    private void createGameObjects(int i) {

        // Run all the grid
        for (int col = 0; col < grid.getCols(); col++) {
            for (int row = 0; row < grid.getRows(); row++) {

                // Player start position
                if (col == 0 && row == 0) {
                    continue;
                }

                // Is path
                if (Level.getLevelMatrix(i)[col][row] == 0) {
                    continue;
                }

                // Add a game object based on the level matrix
                gameObjectList.add(
                        GameObjectFactory.createNewGameObjects(
                                row,
                                col,
                                grid,
                                GameObjectsType.translateMapReference(Level.getLevelMatrix(i)[col][row]), stackArrayList
                        )
                );

            }
        }
    }

    private void retrieveGameObjects() {

        // Save all the objects in their respective stacks
        for (GameObject object : gameObjectList) {

            object.reset();

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

        // Clear the game object list for next level execution
        gameObjectList.clear();

    }

    public void drawObjects() {

        // Draw all the game objects
        for (GameObject go : gameObjectList) {
            go.getGridPosition().show();
        }

        // Draw the players
        player.getPos().show();

    }

}
