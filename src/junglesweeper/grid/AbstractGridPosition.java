package junglesweeper.grid;

/**
 * Created by fabio on 26/05/2017.
 */
public abstract class AbstractGridPosition implements GridPosition {
    private int col;
    private int row;
    private Grid grid;

    public AbstractGridPosition(int col, int row, Grid grid) {
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

    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public Grid getGrid() {
        return grid;
    }

    public abstract void show();

    public abstract void hide();

    @Override
    public void movingDirection(Direction direction) {

        switch (direction){
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

    public void moveUp(){
        int maxRowsUp = 1 < getRow() ? 1 : getRow();
        setPos(getCol(), getRow() - maxRowsUp);
    }

    public void moveDown() {
        int maxRowsDown = 1 > getGrid().getRows() - (getRow() + 1) ? getGrid().getRows() - (getRow() + 1) : 1;
        setPos(getCol(), getRow() + maxRowsDown);
    }

    public void moveLeft() {
        int maxRowsLeft = 1 < getCol() ? 1 : getCol();
        setPos(getCol() - maxRowsLeft, getRow());
    }


    public void moveRight() {
        int maxRowsRight = 1 > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol() + 1) : 1;
        setPos(getCol() + maxRowsRight, getRow());
    }
}
