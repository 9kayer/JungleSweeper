package junglesweeper.grid.position;

import junglesweeper.GridColor;
import junglesweeper.grid.Grid;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public abstract class AbstractGridPosition implements GridPosition {
    private int col;
    private int row;
    private Grid grid;

    public AbstractGridPosition(int col, int row, Grid grid, String imagePath) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public abstract void show();

    public abstract void hide();

    @Override
    public void movingDirection(Direction direction) {

        switch (direction) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    public void moveUp() {

        if (getRow() - 1 >= 0) {
            setPos(getCol(), getRow() - 1);
        }

    }

    public void moveDown() {

        if (getRow() + 1 < grid.getRows()) {
            setPos(getCol(), getRow() + 1);
        }

    }

    public void moveLeft() {

        if (getCol() - 1 >= 0) {
            setPos(getCol() - 1, getRow());
        }

    }

    public void moveRight() {

        if (getCol() + 1 < grid.getCols()) {
            setPos(getCol() + 1, getRow());
        }

    }
}
