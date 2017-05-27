package junglesweeper;

import junglesweeper.gameobjects.GameObject;
import junglesweeper.gameobjects.GameObjectFactory;
import junglesweeper.gameobjects.GameObjectsType;
import junglesweeper.grid.Grid;
import junglesweeper.grid.GridFactory;
import junglesweeper.grid.GridType;
import junglesweeper.simplegfx.SimpleGfxGridPosition;

import java.util.ArrayList;

/**
 * Created by fabio on 26/05/2017.
 */
public class Game {

    private CollisionDetector collisionDetector;
    private ArrayList<ArrayList> gameObjectList;
    private Grid grid;
    private int delay;
    private Level level;

    public Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        gameObjectList = new ArrayList<ArrayList>();
        level = new Level();
        this.delay = delay;
    }

    public void init() {

        grid.init();

        initGameObjectList();

        createGameObjects();
    }

    public void start() {
        throw new UnsupportedOperationException();
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
    }

    public void movePlayer() {
        throw new UnsupportedOperationException();
    }

}
