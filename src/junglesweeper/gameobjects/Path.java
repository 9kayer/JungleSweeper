package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public class Path extends GameObject {

    public Path(GridPosition pos) {
        super(pos, GameObjectsType.PATH);
    }

    public void collide() {
        getGridPosition().hide();
    }

    public GridPosition getPos() {
        return getGridPosition();
    }
}
