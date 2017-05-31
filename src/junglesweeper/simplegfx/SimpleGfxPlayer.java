package junglesweeper.simplegfx;

import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;
import junglesweeper.simplegfx.grid.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
    // Heart pictures
    private Picture livesImg;

    private SimpleGfxGridPosition pos;

    /**
     * SimpleGfxPlayer Constructor
     *
     * @param pos               The player position
     * @param lives             The number of lives
     * @param collisionDetector To validate the player moves
     */
    public SimpleGfxPlayer(GridPosition pos, int lives, CollisionDetector collisionDetector) {
        super(pos, lives, collisionDetector);
        this.pos = (SimpleGfxGridPosition) pos;
        livesImg = new Picture(53, 320, "./assets/Game/hud_heartFull.png");
    }

    /**
     * Attributes the player direction image
     *
     * @param direction Receive the player direction
     * @return A boolean. True if possible or False if not
     */
    public boolean move(Direction direction) {

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

            return false;
        }

        return true;
    }

    /**
     * Makes a reset
     */
    @Override
    public void reset() {
        dropKey();
        pos.setPos(0, 0);
        pos.hide();
    }

    /**
     * Requests a position in the grid
     *
     * @return The grid position
     */
    public GridPosition getPos() {
        return pos;
    }

    @Override
    public void collide() {
        super.collide();
        switch (getLives()) {
            case 1:
                livesImg.load("./assets/Game/hud_heartEmpty.png");
                break;
            case 2:
                livesImg.load("./assets/Game/hud_heartHalf.png");
                break;
            case 3:
                livesImg.load("./assets/Game/hud_heartFull.png");
                break;
        }
    }

    public void show() {
        livesImg.draw();
        pos.show();
    }

}
