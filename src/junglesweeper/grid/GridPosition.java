package junglesweeper.grid;

/**
 * Created by fabio on 26/05/2017.
 */
public interface GridPosition {

    int getCol();

    int getRow();

    void setPos(int col, int row);

    void movingDirection(Direction direction);

    boolean equals(GridPosition gridPosition);

}
