package junglesweeper.simplegfx;

import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.Grid;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;

/**
 * Created by codecadet on 27/05/17.
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
        //pos.show();
    }

    public GridPosition getPos() {
        return pos;
    }
}
