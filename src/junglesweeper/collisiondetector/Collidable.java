package junglesweeper.collisiondetector;

import junglesweeper.grid.position.GridPosition;

/**
 * Created by andrb on 27/05/2017.
 */
public interface Collidable {

    void collide();

    GridPosition getPos();

}
