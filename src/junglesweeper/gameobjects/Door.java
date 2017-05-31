package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
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
