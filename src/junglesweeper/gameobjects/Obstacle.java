package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class Obstacle extends GameObject {

    public Obstacle(GridPosition pos) {
        super(pos, GameObjectsType.OBSTACLE);
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
