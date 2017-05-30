package junglesweeper.simplegfx;

import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;
import junglesweeper.simplegfx.grid.SimpleGfxGridPosition;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SimpleGfxPlayer extends Player {

    public static final String UP_ICON = "./assets/pictures/player-up.png";
    public static final String RIGHT_ICON = "./assets/pictures/player-right.png";
    public static final String DOWN_ICON = "./assets/pictures/player-down.png";
    public static final String LEFT_ICON = "./assets/pictures/player-left.png";

    private SimpleGfxGridPosition pos;

    public SimpleGfxPlayer(GridPosition pos, int lives, CollisionDetector collisionDetector) {
        super(pos, lives, collisionDetector);
        this.pos = (SimpleGfxGridPosition) pos;
    }

    public void move(Direction direction) {

        switch (direction) {
            case UP:
                pos.setPicture(UP_ICON);
                break;
            case RIGHT:
                pos.setPicture(RIGHT_ICON);
                break;
            case DOWN:
                pos.setPicture(DOWN_ICON);
                break;
            case LEFT:
                pos.setPicture(LEFT_ICON);
        }

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
