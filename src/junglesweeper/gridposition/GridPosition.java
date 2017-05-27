package junglesweeper.gridposition;

import junglesweeper.GridColor;

/**
 * Created by fabio on 26/05/2017.
 */
public interface GridPosition {

    int getCol();

    int getRow();

    void setPos(int col, int row);

    void setColor(GridColor color);

    void setText(String text);

    void show();

    void hide();

    void movingDirection(Direction direction);

    boolean equals(GridPosition gridPosition);
}
