package junglesweeper;

import junglesweeper.gameobjects.GameObject;
import junglesweeper.gameobjects.GameObjectFactory;
import junglesweeper.grid.Grid;
import junglesweeper.grid.GridFactory;
import junglesweeper.grid.GridType;
import junglesweeper.simplegfx.controls.ControlType;
import junglesweeper.player.Player;
import junglesweeper.simplegfx.SimpleGfxPlayer;
import junglesweeper.simplegfx.controls.MoveKeyMap;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

/**
 * Created by fabio on 26/05/2017.
 */
public class Game {

    private static final int DELAY = 1;

    private CollisionDetector collisionDetector;
    private ArrayList<ArrayList> gameObjectList;
    private Grid grid;
    private Player player;
    private MoveKeyMap keyMap;
    private Level level;

    public Game(GridType gridType, int cols, int rows) {
        grid = GridFactory.makeGrid(gridType, cols, rows);

        gameObjectList = new ArrayList<ArrayList>();

        keyMap = new MoveKeyMap(ControlType.MODE_1);
        level = new Level();
    }

    public void init() {

        grid.init();
        keyMap.init();

        initGameObjectList();

        createGameObjects();
        
    }

    public void start() throws InterruptedException {

        while (true) {

            if (keyMap.isMoving()) {
                player.move(keyMap.getDirection());
                keyMap.stopMoving();
            }

            Thread.sleep(DELAY);

        }

    }

    public void initGameObjectList() {

        for (int i = 0; i < grid.getCols(); i++) {
            gameObjectList.add(new ArrayList<GameObject>());
        }
    }

    public void createGameObjects() {

        GameObject object;

        for (int col = 0; col < grid.getCols(); col++) {
            for (int row = 0; row < grid.getRows(); row++) {

                if (col == 0 && row == 0) {
                    continue;
                }

                object = GameObjectFactory.createNewGameObjects(row, col, grid, (level.getLevelMatrix()[col][row]));
                object.setCollisionDetector(collisionDetector); // not necessary for rocks
                gameObjectList.get(row).add(object);

            }
        }

        player = new SimpleGfxPlayer(grid, grid.makeGridPosition(0, 0), 3, collisionDetector);

    }

}
