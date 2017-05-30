package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public class Key extends GameObject {

    private boolean active;

    public Key(GridPosition pos) {
        super(pos, GameObjectsType.KEY);
        active = true;
    }

    @Override
    public void collide() {
        getGridPosition().hide();
        active = false;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void reset() {
        active = true;
    }

    @Override
    public GridPosition getPos() {
        return getGridPosition();
    }
}
