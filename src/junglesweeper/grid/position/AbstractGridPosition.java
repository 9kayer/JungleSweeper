package junglesweeper.grid.position;

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

    /**
     * AbstractGridPosition Constructor
     *
     * @param col Receives a column
     * @param row Receives a row
     * @param grid Receives the grid
     * @param imagePath Receives the corresponding image path
     */
    public AbstractGridPosition(int col, int row, Grid grid, String imagePath) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    /**
     * Get the column position
     *
     * @return The column
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * Get the row position
     *
     * @return The row
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Get the Grid position
     *
     * @return
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Set the position
     * @param col To the column
     * @param row to the row
     */
    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    /**
     * Declaration of the method show() to be implemented
     */
    public abstract void show();

    /**
     * Declaration of the method hide() to be implemented
     */
    public abstract void hide();

    /**
     * Move in one direction
     *
     * @param direction Receives the selected direction
     */
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

    /**
     * Implementation of the move to up
     */
    public void moveUp() {

        if (getRow() - 1 >= 0) {
            setPos(getCol(), getRow() - 1);
        }
    }

    /**
     * Implementation of the move to down
     */
    public void moveDown() {

        if (getRow() + 1 < grid.getRows()) {
            setPos(getCol(), getRow() + 1);
        }
    }

    /**
     * Implementation of the move to the left
     */
    public void moveLeft() {

        if (getCol() - 1 >= 0) {
            setPos(getCol() - 1, getRow());
        }
    }

    /**
     * Implementation of the mve to the right
     */
    public void moveRight() {

        if (getCol() + 1 < grid.getCols()) {
            setPos(getCol() + 1, getRow());
        }
    }

    /**
     * Compares the actual position with the grid position
     *
     * @param gridPosition Receives the position in the grid
     * @return True if both are equal otherwise false
     */
    @Override
    public boolean equals(GridPosition gridPosition) {

        if (getCol() == gridPosition.getCol() && getRow() == gridPosition.getRow()) {

            return true;
        }

        return false;
    }
}
