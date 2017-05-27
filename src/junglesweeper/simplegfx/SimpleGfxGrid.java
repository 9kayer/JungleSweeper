package junglesweeper.simplegfx;

import junglesweeper.grid.Grid;
import junglesweeper.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by fabio on 26/05/2017.
 */
public class SimpleGfxGrid implements Grid {

    private static final int CELLSIZE = 35;
    private static final int XPADDING = 100;
    private static final int YPADDING = 10;

    private int cols;
    private int rows;
    private int cellSize;
    private Rectangle screen;

    public int getCellSize() {
        return cellSize;
    }

    public SimpleGfxGrid(int cols, int rows) {
        cellSize = CELLSIZE;
        this.cols = cols;
        this.rows = rows;
        screen = new Rectangle(XPADDING,YPADDING, cols * cellSize ,rows * cellSize);
    }

    @Override
    public void init(){
        screen = new Rectangle(XPADDING,YPADDING, cols * cellSize ,rows * cellSize);
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

    public int getX() {
        return XPADDING;
    }

    public int getY() {
        return YPADDING;
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        SimpleGfxGridPosition cell = new SimpleGfxGridPosition(col,row,this);
        cell.show();
        return cell;
    }

    public int rowToY(int row) {
        return getY() + row * getCellSize();
    }

    public int columnToX(int column) {
        return getX() + column * getCellSize();
    }

}
