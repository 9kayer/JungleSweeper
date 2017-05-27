package junglesweeper.simplegfx;

import junglesweeper.CollisionDetector;
import junglesweeper.grid.Grid;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.simplegfx.controls.ControlType;
import junglesweeper.player.Player;
import junglesweeper.simplegfx.controls.MoveKeyMap;

/**
 * Created by codecadet on 27/05/17.
 */
public class SimpleGfxPlayer extends Player {

    private SimpleGfxGridPosition pos;
    private Direction direction;

    public SimpleGfxPlayer(Grid grid, GridPosition pos, int lives, CollisionDetector collisionDetector) {
        super(grid, pos, lives, collisionDetector);
        this.pos = (SimpleGfxGridPosition) pos;

    }

    public void move(Direction direction) {

        pos.movingDirection(direction);

    }
}
