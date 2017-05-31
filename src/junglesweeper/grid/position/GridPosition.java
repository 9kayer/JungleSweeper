package junglesweeper.grid.position;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public interface GridPosition {

    int getCol();

    int getRow();

    void setPos(int col, int row);

    void show();

    void hide();

    void movingDirection(Direction direction);

    boolean equals(GridPosition gridPosition);

}
