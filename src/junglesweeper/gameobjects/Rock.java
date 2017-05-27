package junglesweeper.gameobjects;

import junglesweeper.gridposition.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public class Rock extends GameObject {

    public Rock(GridPosition pos) {
        super(pos, GameObjectsType.ROCK);
    }
}
