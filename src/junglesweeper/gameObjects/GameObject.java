package junglesweeper.gameObjects;

import junglesweeper.CollisionDetector;
import junglesweeper.gameObjects.collidable.Collidable;
import junglesweeper.grid.CellType;
import junglesweeper.grid.Grid;
import junglesweeper.gridPosition.Direction;
import junglesweeper.gridPosition.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public abstract class GameObject implements Collidable{

    private GridPosition pos;
    private Grid grid;
    private GameObjectsType type;
    private CollisionDetector collisionDetector;
    private Direction currentDirection;


    @Override
    public GridPosition getPos() {
        return null;
    }

    public GameObjectsType getType() {
        return type;
    }

    public Direction getCurrentDirection() {

        return currentDirection;
    }

    public void setPos(GridPosition pos) {

        this.pos = pos;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void move(){

    }

    public boolean isHittingWall(){
        throw new UnsupportedOperationException();
    }

}
