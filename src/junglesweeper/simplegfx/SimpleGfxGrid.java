package junglesweeper.simplegfx;

import junglesweeper.grid.Grid;
import junglesweeper.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by fabio on 26/05/2017.
 */
public class SimpleGfxGrid implements Grid {

    public static final int X_PADDING = 100;
    public static final int Y_PADDING = 10;

    private int cols;
    private int rows;
    private int cellSize;
    private Rectangle screen;

    public int getCellSize() {
        return cellSize;
    }

    public SimpleGfxGrid(int cols, int rows) {
        cellSize = 35;
        this.cols = cols;
        this.rows = rows;
        screen = new Rectangle(X_PADDING, Y_PADDING, cols * cellSize, rows * cellSize);
    }

    @Override
    public void init() {
        screen = new Rectangle(X_PADDING, Y_PADDING, cols * cellSize, rows * cellSize);
        screen.draw();
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

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        SimpleGfxGridPosition cell = new SimpleGfxGridPosition(col, row, this);

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