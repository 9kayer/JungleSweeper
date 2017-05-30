package junglesweeper.grid;

import junglesweeper.simplegfx.grid.SimpleGfxGrid;
import junglesweeper.simplegfx.grid.SimpleGfxGridType;

/**
 * Created by fabio on 26/05/2017.
 */
public class GridFactory {

    public static Grid makeGrid(DisplayType displayType, SimpleGfxGridType simpleGfxGridType) {

        switch(displayType){
            case SIMPLE_GFX:
                switch (simpleGfxGridType){
                    case MAP_GRID:
                        return new SimpleGfxGrid(SimpleGfxGridType.MAP_GRID);
                    case INFO_GRID:
                        return new SimpleGfxGrid(SimpleGfxGridType.INFO_GRID);
                }
            default:
                switch (simpleGfxGridType){
                    case MAP_GRID:
                        return new SimpleGfxGrid(SimpleGfxGridType.MAP_GRID);
                    case INFO_GRID:
                        return new SimpleGfxGrid(SimpleGfxGridType.INFO_GRID);
                }
        }
        return null;
    }
}
