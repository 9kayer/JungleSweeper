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

    public Game(GridType gridType, int cols, int rows, int delay) {
        grid = GridFactory.makeGrid(gridType, cols, rows);

        gameObjectList = new ArrayList<ArrayList>();

        this.delay = delay;
    }

    public void init() {
        grid.init();

        initGameObjectList();
        System.out.println("AQUI");
        System.out.println(grid.getCols());
        createGameObjects();
    }

    public void start() {

    }

    public void initGameObjectList() {
        for (int i = 0; i < grid.getCols(); i++) {
            gameObjectList.add(new ArrayList<GameObject>());
        }
    }

    public void createGameObjects() {

        GameObject object;

        for (int i = 0; i < grid.getCols(); i++) {
            System.out.println("i: " + Integer.toString(i));

            for (int j = 0; j < grid.getRows(); j++) {

                System.out.println("j: " + Integer.toString(j));
                object = GameObjectFactory.createNewGameObjects(i, j, grid, GameObjectsType.values()[(int) (Math.random() * GameObjectsType.values().length)]);
                object.setCollisionDetector(collisionDetector); // not necessary for rocks
                gameObjectList.get(i).add(object);
            }
        }
    }

    public void movePlayer() {

    }

}
