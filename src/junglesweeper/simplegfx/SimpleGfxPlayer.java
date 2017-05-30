package junglesweeper.simplegfx;

import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SimpleGfxPlayer extends Player {

    private SimpleGfxGridPosition pos;

    public SimpleGfxPlayer(GridPosition pos, int lives, CollisionDetector collisionDetector) {
        super(pos, lives, collisionDetector);
        this.pos = (SimpleGfxGridPosition) pos;
    }

    public void move(Direction direction) {
        pos.movingDirection(direction);

        if (!getCollisionDetector().isPossible(getPos())) {
            pos.movingDirection(direction.getReverse(direction));
        }
    }

    @Override
    public void reset() {
        dropKey();
        pos.setPos(0,0);
        pos.hide();
    }

    public GridPosition getPos() {
        return pos;
    }
}
