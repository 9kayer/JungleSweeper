package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public class Tiger extends GameObject {

    public Tiger(GridPosition pos) {
        super(pos, GameObjectsType.TIGER);
    }

    public void collide() {
        getGridPosition().hide();
    }

    public GridPosition getPos() {
        return getGridPosition();
    }


}
