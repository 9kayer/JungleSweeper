package junglesweeper.grid.position;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
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
