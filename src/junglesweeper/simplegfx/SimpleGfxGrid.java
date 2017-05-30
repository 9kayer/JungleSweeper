package junglesweeper.simplegfx;

import junglesweeper.grid.Grid;
import junglesweeper.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SimpleGfxGrid implements Grid {

    private static final int CELL_SIZE = 35;
    private static final int X_PADDING = 100;
    private static final int Y_PADDING = 10;

    private int cols;
    private int rows;
    private Picture pictureScreen;

    public int getCellSize() {
        return CELL_SIZE;
    }

    public SimpleGfxGrid(int cols, int rows, String imagePath) {
        this.cols = cols;
        this.rows = rows;
        pictureScreen = new Picture(X_PADDING, Y_PADDING,imagePath);
    }

    @Override
    public void init() {
        pictureScreen.draw();
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
