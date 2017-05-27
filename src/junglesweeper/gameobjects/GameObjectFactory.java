package junglesweeper.gameobjects;

import junglesweeper.grid.Grid;

/**
 * Created by fabio on 26/05/2017.
 */
public class GameObjectFactory {

    public static GameObject createNewGameObjects(int col, int row, Grid grid , GameObjectsType gameObjectsType){

        switch (gameObjectsType) {
            case KEY:
                return new Key(grid.makeGridPosition(col, row));
            case BUSH:
                return new Bush(grid.makeGridPosition(col, row));
            case ROCK:
                return new Rock(grid.makeGridPosition(col, row));
            case TIGER:
                return new Tiger(grid.makeGridPosition(col, row));
            case DOOR:
                return new Door(grid.makeGridPosition(col, row));
            default:
                return new Bush(grid.makeGridPosition(col,row));
        }
    }
}
