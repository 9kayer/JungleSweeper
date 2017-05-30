package junglesweeper.grid;

import junglesweeper.simplegfx.SimpleGfxGrid;

/**
 * Created by fabio on 26/05/2017.
 */
public class GridFactory {

    public static Grid makeGrid(DisplayType displayType, int cols, int rows) {

        switch(displayType){
            case SIMPLE_GFX:
                return new SimpleGfxGrid(cols,rows, displayType.getImagePath());
            default:
                return new SimpleGfxGrid(cols,rows, displayType.getImagePath());
        }

    }

    public static Display makeDisplay(DisplayType displayType, int padding){
        switch(displayType){
            case SIMPLE_GFX:
                return new SimpleGfxDisplay(padding);
            default:
                return new SimpleGfxDisplay(padding);
        }
    }
}
