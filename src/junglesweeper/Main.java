package junglesweeper;

import junglesweeper.grid.GridType;

public class Main {

    public static void main(String[] args) {

        Game g = new Game(GridType.SIMPLE_GFX,20,20,200);

        g.init();
    }
}
