package junglesweeper.gameobjects;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by codecadet on 27/05/17.
 */
public class Door extends GameObject{

    public Door(GridPosition pos) {
        super(pos, GameObjectsType.DOOR);
    }
}
