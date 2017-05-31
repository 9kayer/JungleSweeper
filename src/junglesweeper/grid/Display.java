package junglesweeper.grid;

import java.util.Stack;

/**
 * Created by codecadet on 30/05/17.
 */
public interface Display {

    Grid getGrid(int priority);

    void showAll();

    void setBackground(String background);

    void showGrid(int priority);

    void hideAll();

    void hideGrid(int priority);

    void makeGrids();
}
