package junglesweeper.simplegfx.grid;

import junglesweeper.grid.Display;
import junglesweeper.grid.DisplayType;
import junglesweeper.grid.Grid;
import junglesweeper.grid.GridFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 30/05/17.
 */
public class SimpleGfxDisplay implements Display {

    private static final int X_PADDING = 10;
    private static final int Y_PADDING = 10;

    private Picture background;
    private Grid infoGrid;
    private Grid mapGrid;
    private DisplayType displayType;
    private int padding;


    public SimpleGfxDisplay(DisplayType displayType, int padding) {
        background = new Picture(X_PADDING, Y_PADDING, "./assets/Game/FinalBG.jpg");
        this.displayType = displayType;
        this.padding = padding;

    }

    public Picture getBackground() {
        return background;
    }

    public Grid getInfoGrid() {
        return infoGrid;
    }

    public Grid getMapGrid() {
        return mapGrid;
    }

    @Override
    public Grid getGrid(int priority) {
        if (SimpleGfxGridType.INFO_GRID.getPriority() == priority) {
            return infoGrid;
        }
        if (SimpleGfxGridType.MAP_GRID.getPriority() == priority) {
            return mapGrid;
        }
        return null;
    }

    @Override
    public void show() {
        background.draw();
        infoGrid.init();
        mapGrid.init();
    }

    @Override
    public void hide() {
        throw new UnsupportedOperationException();
    }

    public void makeGrids() {
        mapGrid = GridFactory.makeGrid(displayType, SimpleGfxGridType.MAP_GRID);
        infoGrid = GridFactory.makeGrid(displayType, SimpleGfxGridType.INFO_GRID);


    }
}
