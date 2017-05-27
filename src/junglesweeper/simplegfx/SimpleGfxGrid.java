package junglesweeper.simplegfx;

import junglesweeper.GridColor;
import junglesweeper.grid.Grid;
import junglesweeper.gridposition.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by fabio on 26/05/2017.
 */
public class SimpleGfxGrid implements Grid {

    public static final int XPADDING = 100;
    public static final int YPADDING = 10;

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
        screen = new Rectangle(XPADDING, YPADDING, cols * cellSize, rows * cellSize);
    }

    @Override
    public void init() {
        screen = new Rectangle(XPADDING, YPADDING, cols * cellSize, rows * cellSize);
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

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col,row, GridColor.RED,this);
    }

    public int rowToY(int row) {
        return YPADDING + cellSize * row;
    }

    public int columnToX(int column) {
        return XPADDING + cellSize * column ;
    }
}
