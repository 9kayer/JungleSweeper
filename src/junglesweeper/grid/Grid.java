package junglesweeper.grid;

import junglesweeper.gridposition.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public interface Grid {

    int getRows();

    int getCols();

    void init();

    GridPosition makeGridPosition(int col, int row);

}
