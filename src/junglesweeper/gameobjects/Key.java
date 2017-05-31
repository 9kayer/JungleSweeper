package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
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
