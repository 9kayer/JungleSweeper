package junglesweeper.grid;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public interface Display {

    Grid getGrid(int priority);

    void show();

    void hide(); //TODO: To be deleted?

    void makeGrids();
}
