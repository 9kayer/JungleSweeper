package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public class Key extends GameObject {

    public Key(GridPosition pos) {
        super(pos, GameObjectsType.KEY);
    }

    public void collide() {
        getGridPosition().hide();
    }

    public GridPosition getPos() {
        return getGridPosition();
    }
}
