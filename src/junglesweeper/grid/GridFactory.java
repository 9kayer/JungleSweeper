package junglesweeper.grid;

import junglesweeper.simplegfx.grid.SimpleGfxGrid;
import junglesweeper.simplegfx.grid.SimpleGfxGridType;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class GridFactory {

    public static Grid makeGrid(DisplayType displayType, SimpleGfxGridType simpleGfxGridType) {

        switch (displayType) {

            case SIMPLE_GFX:
                switch (simpleGfxGridType) {
                    case MAP_GRID:
                        return new SimpleGfxGrid(SimpleGfxGridType.MAP_GRID);
                    case INFO_GRID:
                        return new SimpleGfxGrid(SimpleGfxGridType.INFO_GRID);
                }

        }
        return null;
    }
}
