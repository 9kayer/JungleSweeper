package junglesweeper.grid;

import java.util.Stack;

/**
 * Created by codecadet on 30/05/17.
 */
public interface Display {

    Stack< ? extends Grid > getDisplayStack();

    void show();

    void hide();

}
