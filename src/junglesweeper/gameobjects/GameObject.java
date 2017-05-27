package junglesweeper.gameobjects;

import junglesweeper.CollisionDetector;
import junglesweeper.gameobjects.collidable.Collidable;
import junglesweeper.grid.Grid;
import junglesweeper.gridposition.Direction;
import junglesweeper.gridposition.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public abstract class GameObject implements Collidable {

    private GridPosition pos;
    private Grid grid;
    private GameObjectsType type;
    private CollisionDetector collisionDetector;
    private Direction currentDirection;

    public GameObject(GridPosition pos, GameObjectsType gameObjectsType){
        this.pos = pos;
        this.type = gameObjectsType;

        pos.setColor(gameObjectsType.getColor());
        pos.setText(gameObjectsType.getText());

        currentDirection = null;
    }

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
