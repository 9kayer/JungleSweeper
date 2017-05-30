package junglesweeper;

import junglesweeper.grid.DisplayType;

/**
 * Created by fabio on 26/05/2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game g = new Game(DisplayType.SIMPLE_GFX,17,17);

        g.init();
        g.start();
    }
}
