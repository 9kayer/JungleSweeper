package junglesweeper.simplegfx.grid;

import junglesweeper.grid.Grid;
import junglesweeper.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SimpleGfxGrid implements Grid {

    private int CELL_SIZE = 40;
    private int X_PADDING = 190;
    private int Y_PADDING = 35;
    private int cols;
    private int rows;

    private Picture pictureScreen;

    public int getCellSize() {
        return CELL_SIZE;
    }

    public SimpleGfxGrid(SimpleGfxGridType simpleGfxGridType) {
        CELL_SIZE = simpleGfxGridType.getCellSize();
        this.X_PADDING = simpleGfxGridType.getxPadding();
        this.Y_PADDING = simpleGfxGridType.getyPadding();
        this.cols = simpleGfxGridType.getCols();
        this.rows = simpleGfxGridType.getRows();
        pictureScreen = new Picture(X_PADDING, Y_PADDING, simpleGfxGridType.getImagePath());
    }

    @Override
    public void init() {
        pictureScreen.draw();
    }

    @Override
    public void hide() {
        pictureScreen.delete();
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public int getRows() {
        return rows;
    }

    public int getX() {
        return X_PADDING;
    }

    public int getY() {
        return Y_PADDING;
    }

    @Override
    public GridPosition makeGridPosition(int col, int row, String imagePath) {
        SimpleGfxGridPosition cell = new SimpleGfxGridPosition(col,row,this, imagePath);

        return cell;
    }

    public int rowToY(int row) {
        return Y_PADDING + row * getCellSize();
    }

    public int columnToX(int column) {
        return X_PADDING + column * getCellSize();
    }
}
