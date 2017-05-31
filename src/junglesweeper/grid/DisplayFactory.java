package junglesweeper.grid;

import junglesweeper.simplegfx.grid.SimpleGfxDisplay;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class DisplayFactory {

    public static Display makeDisplay(DisplayType displayType, int padding) {

        switch (displayType) {

            case SIMPLE_GFX:
                return new SimpleGfxDisplay(displayType, padding);
            default:
                return new SimpleGfxDisplay(displayType, padding);
        }
    }
}
