package junglesweeper;

import junglesweeper.collisiondetector.Collidable;
import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.gameobjects.*;
import junglesweeper.grid.*;
import junglesweeper.simplegfx.SimpleGfxSensor;
import junglesweeper.player.Player;
import junglesweeper.simplegfx.SimpleGfxPlayer;
import junglesweeper.simplegfx.controls.MoveKeyMap;
import junglesweeper.sensor.Sensor;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class Game {

    private static final int DELAY = 25;
    private static final int FIRST_LEVEL = 0;

    private ArrayList<GameObject> gameObjectList;
    private ArrayList<Stack<GameObject>> stackArrayList;
    private CollisionDetector collisionDetector;
    private Display display;
    private Sensor sensor;
    private Player player;
    private MoveKeyMap keyMap;
    private SimpleGfxSensor traps;

    public Game(DisplayType displayType, int cols, int rows) {

        display = DisplayFactory.makeDisplay(displayType, 10);
        display.makeGrids();

        gameObjectList = new ArrayList<>();
        keyMap = new MoveKeyMap(MoveKeyMap.ControlType.MODE_1);
        sensor = new Sensor(cols, rows, FIRST_LEVEL);
        stackArrayList = new ArrayList<>();
        collisionDetector = new CollisionDetector();

    }

    public void init() {

        // Init the stacks for game object collection
        for (int i = 0; i < GameObjectsType.values().length; i++) {
            stackArrayList.add(new Stack<>());
        }

        // Load the keyboard handler
        keyMap.init();

        // Load the danger sensor
        sensor.init();

        // Start the player
        player = new SimpleGfxPlayer(
                display.getGrid(1).makeGridPosition(0, 0, SimpleGfxPlayer.DOWN_ICON),
                3,
                collisionDetector
        );

        // After Create the game Objects we print the number of traps around them
        traps = new SimpleGfxSensor(sensor.getEnemies(player.getPos().getCol(), player.getPos().getRow()));

        //Waiting for player to press Space or Q key to start the game
        while (!keyMap.isSpecialKey()) {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void start() throws InterruptedException {

        // Collidable to check
        Collidable object;

        // Level walkthrough
        for (int i = 0; i < Level.NUM_LEVELS && player.isActive(); i++) {

            // Create the level
            createLevel(i);

            //Draw all Grids
            display.showGrid(1);
            display.showGrid(2);

            // Draw all the objects
            drawObjects();

            // While player is alive
            while (player.isActive()) {

                // Move player and check for collisions
                if ((object = movePlayer()) == null) {
                    continue;
                }

                if (object instanceof Tiger) {
                    i--;
                    break;
                }

                if (object instanceof Door && object.isActive()) {
                    break;
                }


                Thread.sleep(DELAY);

            }

        }

        if (!player.isActive()) {
            // show game over
        } else  {
            // Winner
        }
    }

    private Collidable movePlayer() {

        // If a key is being pressed
        if (keyMap.isMoving()) {
            // Move the player one cell at a time
            player.getPos().hide();

            player.move(keyMap.getDirection());

            drawPath();

            player.getPos().show();

            keyMap.stopMoving();

            // Update the danger sensor output
            traps.reWrite(sensor.getEnemies(player.getPos().getCol(), player.getPos().getRow()));

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
        for (int col = 0; col < display.getGrid(1).getCols(); col++) {
            for (int row = 0; row < display.getGrid(1).getRows(); row++) {

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
                        GameObjectFactory.create(
                                row,
                                col,
                                display.getGrid(1),
                                GameObjectsType.get(Level.getLevelMatrix(i)[col][row]),
                                stackArrayList
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
            if (!go.getType().equals(GameObjectsType.TIGER)) {
                go.getGridPosition().show();
            }
        }
        drawPath();

        // Draw the players
        //player.getPos().show();
        player.show();

        traps.show();

    }

    private void drawPath() {

        GameObject newPath = GameObjectFactory.create(player.getPos().getCol(), player.getPos().getRow(),
                display.getGrid(1), GameObjectsType.PATH, stackArrayList);
        newPath.getPos().show();
        gameObjectList.add(newPath);

    }

}
