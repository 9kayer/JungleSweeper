package junglesweeper.grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Stack;

/**
 * Created by codecadet on 30/05/17.
 */
public class SimpleGfxDisplay implements Display {

    private Picture background;
    private Grid infoGrid;
    private Grid mapGride;
    private DisplayType displayType;
    private int padding;


    public SimpleGfxDisplay(DisplayType displayType, int padding){
        background = new Picture(5,5, "./assets/pictures/back.png");
        this.displayType = displayType;
        this.padding = padding;

    }

    public Picture getBackground() {
        return background;
    }

    public Grid getInfoGrid() {
        return infoGrid;
    }

    public Grid getMapGride() {
        return mapGride;
    }

    @Override
    public Grid getGrid(int priority) {
        if(SimpleGfxGridType.INFO_GRID.getPriority() == priority){
            return infoGrid;
        }
        if(SimpleGfxGridType.MAP_GRID.getPriority() == priority){
            return mapGride;
        }
        return null;
    }

    @Override
    public void show() {
        background.draw();
        infoGrid.init();
        mapGride.init();
    }

    @Override
    public void hide() {

    }

    public void makeGrids(){
        mapGride = GridFactory.makeGrid(displayType, SimpleGfxGridType.MAP_GRID);
        infoGrid = GridFactory.makeGrid(displayType, SimpleGfxGridType.INFO_GRID);


    }
}
