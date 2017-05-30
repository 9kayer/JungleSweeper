package junglesweeper.grid;

import junglesweeper.simplegfx.SimpleGfxGrid;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class GridFactory {

    public static Grid makeGrid(GridType gridType, int cols, int rows) {

        switch(gridType){

            case SIMPLE_GFX:
                return new SimpleGfxGrid(cols,rows,gridType.getImagePath());
            default:
                return new SimpleGfxGrid(cols,rows, gridType.getImagePath());
        }
    }
}
