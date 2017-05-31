package junglesweeper.grid;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public interface Display {

    Grid getGrid(int priority);

    void showAll();

    void hide(); //TODO: To be deleted?

    void setBackground(String background);

    void showGrid(int priority);

    void hideAll();

    void hideGrid(int priority);

    void makeGrids();
}
