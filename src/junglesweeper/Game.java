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
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
    private static final int PLAYER_LIVES = 3;

    /**
     * ArrayList for store all the game objects
     * except the player itself
     */
    private ArrayList<GameObject> gameObjectList;

    /**
     * Stack for store all the game objects for level transition
     * Auxiliary for object recycle
     */
    private ArrayList<Stack<GameObject>> stackArrayList;

    /**
     * Detects and reacts to collisions between player and game objects
     */
    private CollisionDetector collisionDetector;

    /**
     * Initialize the backgrounds
     */
    private Display display;

    /**
     * Check and alerts the player for enemies around him
     */
    private Sensor sensor;
    private SimpleGfxSensor traps;

    /**
     * The MIGHT ONE, aka player
     */
    private Player player;

    /**
     * Keyboard Handler
     */
    private MoveKeyMap keyMap;

    /**
     * Pop up windows
     */
    private Picture gameOverPic;
    private Picture congratz;

    /**
     * Sound library
     */
    private Sound music;

    /**
     * Game contructor
     *
     * @param displayType the kind of display to construct (attempt of agnostic implementation)
     * @param cols        number of cols
     * @param rows        number of rows
     */
    public Game(DisplayType displayType, int cols, int rows) {

        // Construct and initialize the grids
        display = DisplayFactory.makeDisplay(displayType, 10);
        display.makeGrids();

        // Construct and initialize the music
        music = new Sound(Sound.getMusicList()[0]);
        music.setLoop(1000);

        gameObjectList = new ArrayList<>();
        keyMap = new MoveKeyMap(MoveKeyMap.ControlType.MODE_1);
        sensor = new Sensor(cols, rows, FIRST_LEVEL);
        stackArrayList = new ArrayList<>();
        collisionDetector = new CollisionDetector();
        gameOverPic = new Picture(350 / 2, 250 / 2, "resources/pictures/GameOver.png");
        congratz = new Picture(350 / 2, 250 / 2, "resources/pictures/congratz.png");

    }

    /**
     * Prepare the game for execution
     */
    public void init() {

        // Start the music
        music.play();

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
                PLAYER_LIVES,
                collisionDetector
        );

        // After Create the game Objects we print the number of traps around them
        traps = new SimpleGfxSensor(sensor.getEnemies(player.getPos().getCol(), player.getPos().getRow()));

        // Waiting for player to press Space or Q key to start the game
        initialScreen();

        //change to guide screen
        display.setBackground("resources/pictures/instructions.jpg");

        initialScreen();

        display.setBackground("resources/pictures/FinalBG2.jpg");
    }

    public void start() throws InterruptedException {

        while (true) {

            playGame();

            if(!afterGame()){
                break;
            }

        }
    }

    private boolean afterGame() throws InterruptedException{

        keyMap.lockDirectionKeys();

        if (!player.isActive()) {
            gameOverPic.draw();
            music.stop();
            music.close();
            music = new Sound(Sound.getMusicList()[1]);
            music.setLoop(1000);
            music.play();
        }
        else{
            congratz.draw();
            music.stop(); //TODO: put some winner's background
            music.close();
            music = new Sound(Sound.getMusicList()[2]);
            music.setLoop(1000);
            music.play();
        }

        while (true){

            if (keyMap.isLeave()){
                return false;
            }

            if (keyMap.isSpaceKey()){
                restartGame();
                keyMap.endSpace();
                return true;
            }

            Thread.sleep(DELAY);
        }
    }

    private void playGame() throws InterruptedException {

        Collidable object;
        music.stop();
        music.close();
        music = new Sound(Sound.getMusicList()[3]);
        music.setLoop(1000);


        // Level walkthrough
        for (int i = 0; i < Level.NUM_LEVELS && player.isActive(); i++) {

            music.play();

            keyMap.freeDirectionKey();

            // Create the level
            createLevel(i);

            //Draw all Grids
            display.showAll();

            //displays number of enemies
            traps.show();

            // Draw all the objects
            drawObjects();

            // While player is alive
            while (player.isActive()) {

                // Move player and check for collisions
                if ((object = movePlayer()) == null) {
                    continue;
                }

                if (object instanceof Enemy) {
                    i--;
                    break;
                }

                if (object instanceof Door && object.isActive()) {
                    music.stop();
                    music.close();
                    if(3 + i +1 >= Level.NUM_LEVELS){
                        continue;
                    }
                    music = new Sound(Sound.getMusicList()[3 + i + 1]);
                    music.setLoop(1000);
                    break;
                }

                Thread.sleep(DELAY);

            }

            removeObjects();

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

        gameOverPic.delete();

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
                                col,
                                row,
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
                case OBSTACLE:
                    stackArrayList.get(2).push(object);
                    object.getGridPosition().hide();
                    break;
                case ENEMY:
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

            if (go.getType().equals(GameObjectsType.ENEMY)) {
                continue;
            }

            go.getGridPosition().show();

        }

        drawPath();

        // Draw the players
        player.show();

        traps.show();

    }

    private void drawPath() {

        GameObject newPath = GameObjectFactory.create(player.getPos().getCol(), player.getPos().getRow(),
                display.getGrid(1), GameObjectsType.PATH, stackArrayList);
        newPath.getPos().show();
        gameObjectList.add(newPath);

    }

    private void removeObjects() {

        retrieveGameObjects();

        player.reset();

        display.hideAll();

        traps.hide();

    }

    private void initialScreen() {

        while (!keyMap.isSpaceKey()) {
            try {

                Thread.sleep(DELAY);

                if (keyMap.isLeave()) {
                    throw new UnsupportedOperationException("No game for me please");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
        keyMap.endSpace();
    }


    private void restartGame(){
        music.stop();
        music.close();
        player.restartLives();
        gameOverPic.delete();
    }
}
