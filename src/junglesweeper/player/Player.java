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
    private int maxlives;
    private CollisionDetector collisionDetector;

    // Initialize our Player
    public Player(GridPosition pos, int lives, CollisionDetector collisionDetector) {
        this.pos = pos;
        this.lives = lives;
        this.maxlives = lives;
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


    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

    public abstract boolean move(Direction direction);

    public abstract void show();

    @Override
    public void collide() {
        lives--;
    }

    @Override
    public boolean isActive() {
        return lives > 0;
    }

    @Override
    public GridPosition getPos() {
        return pos;
    }

    public void restartLives(){
        System.out.println("restarting lives");
        lives = maxlives;

    }

    public int getLives() {
        return lives;
    }
}
