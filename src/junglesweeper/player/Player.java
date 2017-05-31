package junglesweeper.player;

import junglesweeper.collisiondetector.Collidable;
import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.grid.position.Direction;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
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

    public abstract boolean move(Direction direction);

    @Override
    public void collide() {
        lives--;
    }

    @Override
    public boolean isActive() {
        throw new UnsupportedOperationException();
    }

    @Override
    public GridPosition getPos() {
        return pos;
    }
}
