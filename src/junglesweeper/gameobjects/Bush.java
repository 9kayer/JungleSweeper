package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public class Bush extends GameObject{

    public Bush(GridPosition pos) {
        super(pos, GameObjectsType.BUSH);
    }
}
