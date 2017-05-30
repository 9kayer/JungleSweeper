package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public class Tiger extends GameObject {

    public Tiger(GridPosition pos) {
        super(pos, GameObjectsType.TIGER);
    }

    @Override
    public void collide() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isActive() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reset() {
        // Nothing to execute
    }

    @Override
    public GridPosition getPos() {
        return getGridPosition();
    }


}
