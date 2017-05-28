package junglesweeper.grid.position;

/**
 * Created by codecadet on 26/05/17.
 */
public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;

    public Direction getReverse(Direction direction) {

        switch (direction) {
            case UP:
                return DOWN;
            case RIGHT:
                return LEFT;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
        }

        return null;
    }

}
