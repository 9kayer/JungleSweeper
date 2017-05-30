package junglesweeper.player;

import junglesweeper.collisiondetector.Collidable;
import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.gameobjects.Key;
import junglesweeper.grid.Grid;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.grid.position.Direction;

import java.util.SimpleTimeZone;


/**
 * Created by fabio on 26/05/2017.
 */
public abstract class Player implements Collidable {

    private GridPosition pos;
    private boolean key;
    private int lives;
    private CollisionDetector collisionDetector;

    // Initialize our Player
    public Player(GridPosition pos, int lives, CollisionDetector collisionDetector) {
        this.pos = pos;
        this.lives = lives;
        this.collisionDetector = collisionDetector;
    }

    public boolean hasKey() {
        return key;
    }

    public void collectKey() {
        key = true;
    }

    public void dropKey() {
        key = false;
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

    public abstract void move(Direction direction);

    @Override
    public void collide() {
        lives--;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public GridPosition getPos() {
        return pos;
    }
}
