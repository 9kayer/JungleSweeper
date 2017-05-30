package junglesweeper.gameobjects;

import junglesweeper.collisiondetector.Collidable;
import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.Grid;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public abstract class GameObject implements Collidable {

    private GridPosition gridPosition;
    private GameObjectsType type;

    public GameObject(GridPosition gridPosition, GameObjectsType gameObjectsType) {
        this.gridPosition = gridPosition;
        this.type = gameObjectsType;

    }
    
    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public GameObjectsType getType() {
        return type;
    }

    public void setGridPosition(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
    }

}
