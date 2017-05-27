package junglesweeper.grid;

import junglesweeper.simplegfx.SimpleGfxGrid;

/**
 * Created by fabio on 26/05/2017.
 */
public class GridFactory {

    public static Grid makeGrid(GridType gridType, int cols, int rows) {

        switch(gridType){
            case SIMPLE_GFX:
                return new SimpleGfxGrid(cols,rows);
            default:
                return new SimpleGfxGrid(cols,rows);
        }

    }
}
