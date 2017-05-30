package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by codecadet on 27/05/17.
 */
public class Door extends GameObject {

    private boolean active;

    public Door(GridPosition pos) {
        super(pos, GameObjectsType.DOOR);
    }

    @Override
    public void collide() {
        active = true;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void reset() {
        active = false;
    }

    @Override
    public GridPosition getPos() {
        return getGridPosition();
    }

}
