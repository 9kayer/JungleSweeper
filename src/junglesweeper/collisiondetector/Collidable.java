package junglesweeper.collisiondetector;

import junglesweeper.grid.position.GridPosition;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public interface Collidable {

    void collide();

    boolean isActive();

    void reset();

    GridPosition getPos();

}
