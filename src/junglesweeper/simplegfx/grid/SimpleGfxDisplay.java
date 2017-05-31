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
        background = new Picture(X_PADDING, Y_PADDING, "./assets/pictures/bg.jpg");
        this.displayType = displayType;
        this.padding = padding;
        background.draw();

    }

    public void setBackground(String string) {
        background.load(string);
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
    public void showAll() {
        //background.draw();
        infoGrid.init();
        mapGrid.init();
    }

    @Override
    public void showGrid(int priority) {
        if (SimpleGfxGridType.INFO_GRID.getPriority() == priority) {
            infoGrid.init();
            return;
        }
        if (SimpleGfxGridType.MAP_GRID.getPriority() == priority) {
            mapGrid.init();
            return;
        }
    }

    @Override
    public void hideGrid(int priority) {
        if (SimpleGfxGridType.INFO_GRID.getPriority() == priority) {
            infoGrid.hide();
            return;
        }
        if (SimpleGfxGridType.MAP_GRID.getPriority() == priority) {
            mapGrid.hide();
            return;
        }
    }

    @Override
    public void hideAll() {
        infoGrid.hide();
        mapGrid.hide();
    }

    public void makeGrids() {
        mapGrid = GridFactory.makeGrid(displayType, SimpleGfxGridType.MAP_GRID);
        infoGrid = GridFactory.makeGrid(displayType, SimpleGfxGridType.INFO_GRID);


    }
}
