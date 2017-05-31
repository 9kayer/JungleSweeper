package junglesweeper.grid;

import junglesweeper.grid.position.GridPosition;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public interface Grid {

    int getRows();

    int getCols();

    void init();

    void hide();

    GridPosition makeGridPosition(int col, int row, String layout);

}
