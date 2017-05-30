package junglesweeper.simplegfx;

import junglesweeper.GridColor;
import junglesweeper.grid.Grid;
import junglesweeper.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by fabio on 26/05/2017.
 */
public class SimpleGfxGrid implements Grid {

    private static final int CELL_SIZE = 35;
    private static final int X_PADDING = 100;
    private static final int Y_PADDING = 10;

    private int cols;
    private int rows;
    private Picture pictureScreen;
    private Rectangle screen;

    public int getCellSize() {
        return CELL_SIZE;
    }

    public SimpleGfxGrid(int cols, int rows, String imagePath) {
        this.cols = cols;
        this.rows = rows;
        pictureScreen = new Picture(X_PADDING, Y_PADDING,imagePath);
        screen = new Rectangle(X_PADDING, Y_PADDING, cols * getCellSize(), rows * getCellSize());
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

    public int getWidth() {
        return screen.getWidth();
    }

    public int getHeight() {
        return screen.getHeight();
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

        cell.show();

        return cell;
    }

    public int rowToY(int row) {
        return Y_PADDING + row * getCellSize();
    }

    public int columnToX(int column) {
        return X_PADDING + column * getCellSize();
    }

}
