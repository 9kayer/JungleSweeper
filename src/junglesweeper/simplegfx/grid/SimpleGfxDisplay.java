package junglesweeper.simplegfx.grid;

import junglesweeper.grid.Display;
import junglesweeper.grid.DisplayType;
import junglesweeper.grid.Grid;
import junglesweeper.grid.GridFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SimpleGfxDisplay implements Display {

    private static final int X_PADDING = 10;
    private static final int Y_PADDING = 10;

    private Picture background;
    private Grid infoGrid;
    private Grid mapGrid;
    private DisplayType displayType;
    private int padding; //TODO: To be deleted?

    /**
     * Game display type
     *
     * @param displayType Display type
     * @param padding     Distance from canvas to the game border
     */
    public SimpleGfxDisplay(DisplayType displayType, int padding) {
        background = new Picture(X_PADDING, Y_PADDING, "./assets/Game/FinalBG.jpg");

        background = new Picture(X_PADDING, Y_PADDING, "./assets/pictures/bg.jpg");
        this.displayType = displayType;
        this.padding = padding;
        background.draw();

    }

    public void setBackground(String string) {
        background.load(string);
    }

    public Grid getInfoGrid() { //TODO: To be deleted?

        return infoGrid;
    }

    public Grid getMapGrid() { //TODO: To be deleted?

        return mapGrid;
    }

    /**
     * Prioritize the Grid
     *
     * @param priority Value of the priority
     * @return The information or the map Grid
     */
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

    /**
     * Draw the background and initialize both grids
     */
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

    /**
     * Procude the requested grids
     */
    public void makeGrids() {
        mapGrid = GridFactory.makeGrid(displayType, SimpleGfxGridType.MAP_GRID);
        infoGrid = GridFactory.makeGrid(displayType, SimpleGfxGridType.INFO_GRID);

    }
}
