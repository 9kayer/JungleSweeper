package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public class Rock extends GameObject {

    public Rock(GridPosition pos) {
        super(pos, GameObjectsType.ROCK);
    }

    public void collide() {
        // No actions on collide
    }

    public GridPosition getPos() {
        return getGridPosition();
    }
}
