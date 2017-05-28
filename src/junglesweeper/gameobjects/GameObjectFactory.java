package junglesweeper.gameobjects;

import com.sun.org.apache.regexp.internal.RE;
import junglesweeper.grid.Grid;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fabio on 26/05/2017.
 */
public class GameObjectFactory {

    public static GameObject createNewGameObjects(int col, int row, Grid grid , GameObjectsType gameObjectsType, ArrayList<Stack<GameObject>> stackArrayList){
        int i = 0;
        GameObject object;
        System.out.println(++i);

        switch (gameObjectsType) {
            case KEY:
                if (stackArrayList.get(0).empty()) {
                    return new Key(grid.makeGridPosition(col, row));
                }
                object = stackArrayList.get(0).pop();
                object.getGridPosition().setPos(col, row);
                return object;
            case PATH:
                if (stackArrayList.get(1).empty()) {
                    return new Path(grid.makeGridPosition(col, row));
                }
                object = stackArrayList.get(1).pop();
                object.getGridPosition().setPos(col, row);
                return object;
            case ROCK:
                if(stackArrayList.get(2).empty()){
                    return new Rock(grid.makeGridPosition(col, row));
                }
                object = stackArrayList.get(2).pop();
                object.getGridPosition().setPos(col,row);
                return object;
            case TIGER:
                if(stackArrayList.get(3).empty()){
                    return new Tiger(grid.makeGridPosition(col, row));
                }
                object = stackArrayList.get(3).pop();
                object.getGridPosition().setPos(col, row);
                return object;
            case DOOR:
                if(stackArrayList.get(4).empty()){
                    return new Door(grid.makeGridPosition(col, row));
                }
                object = stackArrayList.get(4).pop();
                object.getGridPosition().setPos(col, row);
                return object;
            default:
                System.out.println("Something went terribly wrong!");
                if (stackArrayList.get(1).empty()) {
                    return new Path(grid.makeGridPosition(col, row));
                }
                object = stackArrayList.get(1).pop();
                object.getGridPosition().setPos(col, row);
                return object;
        }
    }


}
