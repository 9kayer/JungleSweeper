package junglesweeper;

import junglesweeper.grid.DisplayType;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game jungleSweeper = new Game(DisplayType.SIMPLE_GFX, 18, 16);

        jungleSweeper.init();
        jungleSweeper.start();

    }
}
