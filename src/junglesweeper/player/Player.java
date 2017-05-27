package junglesweeper.player;

import junglesweeper.CollisionDetector;
import junglesweeper.gameobjects.Collidable;
import junglesweeper.grid.Grid;
import junglesweeper.gridposition.GridPosition;
import junglesweeper.gridposition.Direction;


/**
 * Created by fabio on 26/05/2017.
 */
public abstract class Player implements Collidable {

    private GridPosition pos;
    private MoveKeyMap keyboard;
    private boolean hasKey;
    private int lives;
    private Direction direction;
    private CollisionDetector collisionDetector;


    // Inicializate our Player
    public Player(GridPosition pos, ControlType type, int lives , CollisionDetector collisionDetector) {
        this.pos = pos;
        keyboard = new MoveKeyMap(type);
        this.lives = lives;
        this.direction = Direction.DOWN;
        this.collisionDetector = collisionDetector;
    }

    //Getter's ----

    public void accelerate() {

        Direction newDirection = direction;

        // Accelerate in the choosen direction

            getPos().movingDirection(newDirection);

            /*if (collisionDetector.isUnSafe(getPos())) {
                break;
            }*/

    }

    @Override
    public GridPosition getPos() {
        return pos;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public int getLives() {
        return lives;
    }
}
