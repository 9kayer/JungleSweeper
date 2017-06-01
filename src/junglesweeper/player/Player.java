package junglesweeper.player;

import junglesweeper.collisiondetector.Collidable;
import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.grid.position.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public abstract class Player implements Collidable {

    private GridPosition pos;
    private boolean key;
    private int lives;
    private Picture keyPic;
    private CollisionDetector collisionDetector;

    /**
     * Initialize our Player
     *
     * @param pos Receives a position
     * @param lives Receives the number of lives
     * @param collisionDetector
     */
    public Player(GridPosition pos, int lives, CollisionDetector collisionDetector) {
        this.pos = pos;
        this.lives = lives;
        this.collisionDetector = collisionDetector;
        keyPic = new Picture(110 , 320,"./assets/Game/nokey.png");
    }

    /**
     * Player has the key
     *
     * @return A boolean
     */
    public boolean hasKey() {
        return key;
    }

    /**
     * Flags the key as collected
     */
    public void collectKey() {
        keyPic.load("./assets/Game/key.png");
        key = true;
    }

    /**
     * Flags the key as dropped
     */
    public void dropKey() {
        keyPic.load("./assets/Game/nokey.png");
        key = false;
    }

    public boolean isAlive() {
        return lives > 0;
    }

    /**
     * Get the player collision detector
     * @return A collisionDetector
     */
    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

    /**
     * Abstrat method to be implemented
     *
     * @param direction A move direction
     * @return A boolean
     */
    public abstract boolean move(Direction direction);

    public abstract void show();

<<<<<<< HEAD
    /**
     * Decrease lives if catch up by a jungle trap
     */
=======
    public void keyPicShow(){
        keyPic.draw();
    }

>>>>>>> 6897b6019b70febc9cdfc8ad3e9903a5079027ab
    @Override
    public void collide() {
        lives--;
    }

    /**
     * Asks if the player is alive
     *
     * @return throws an exception
     */
    @Override
    public boolean isActive() {
        return lives > 0;
    }

    /**
     * Request a grid position
     *
     * @return A posiiton in the grid
     */
    @Override
    public GridPosition getPos() {
        return pos;
    }

    public int getLives() {
        return lives;
    }
}
