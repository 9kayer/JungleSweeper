package junglesweeper.grid;

import java.util.Stack;

/**
 * Created by codecadet on 30/05/17.
 */
public interface Display {

    Grid getGrid(int priority);

    void show();

    void hide();

    void makeGrids();
}
