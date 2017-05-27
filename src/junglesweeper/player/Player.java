package junglesweeper.player;

import junglesweeper.collisiondetector.Collidable;
import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.Grid;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.grid.position.Direction;


/**
 * Created by fabio on 26/05/2017.
 */
public abstract class Player implements Collidable {

    private Grid grid;
    private GridPosition pos;
    private boolean hasKey;
    private int lives;
    private CollisionDetector collisionDetector;


    // Initialize our Player
    public Player(Grid grid, GridPosition pos, int lives, CollisionDetector collisionDetector) {
        this.grid = grid;
        this.pos = pos;
        this.lives = lives;
        this.collisionDetector = collisionDetector;
    }

    public GridPosition getPos() {
        return pos;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public int getLives() {
        return lives;
    }

    public abstract void move(Direction direction);

    public void collide() {
        throw new UnsupportedOperationException();
    }

}
