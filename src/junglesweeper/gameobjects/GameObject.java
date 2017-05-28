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
    private Grid grid;
    private GameObjectsType type;
    private CollisionDetector collisionDetector;
    private Direction currentDirection;


    public GameObject(GridPosition gridPosition, GameObjectsType gameObjectsType) {
        this.gridPosition = gridPosition;
        this.type = gameObjectsType;

        this.gridPosition.setColor(gameObjectsType.getColor());

        currentDirection = null;
    }
    
    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public GameObjectsType getType() {
        return type;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void setGridPosition(GridPosition gridPosition) {
        this.gridPosition = gridPosition;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
}
