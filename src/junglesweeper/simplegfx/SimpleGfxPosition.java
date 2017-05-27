package junglesweeper.simplegfx;

import junglesweeper.grid.AbstractGridPosition;
import junglesweeper.grid.Direction;
import junglesweeper.grid.GridPosition;

/**
 * Created by fabio on 26/05/2017.
 */
public class SimpleGfxPosition extends AbstractGridPosition {

    private SimpleGfxGrid simpleGfxGrid;

    public SimpleGfxPosition(int col, int row, SimpleGfxGrid simpleGfxGrid) {

        super(col, row, simpleGfxGrid);

        this.simpleGfxGrid = simpleGfxGrid;
    }

    @Override
    public void setPos(int col, int row) {
        super.setPos(col,row);
    }

    @Override
    public void movingDirection(Direction direction) {
        int lastMoveCol = getPos().getCol();
        int lastMoveRow = getPos().getRow();
        accelerate();
        int dX = grid.columnToX(getPos().getCol()) - grid.columnToX(lastMoveCol);
        int dY = grid.rowToY(getPos().getRow()) - grid.rowToY(lastMoveRow);
        picture.translate(dX, dY);
    }

    @Override
    public boolean equals(GridPosition gridPosition) {
        return false;
    }

    public int rowToY(int row) {
        return YPADDING + cellSize * row;
    }

    public int columnToX(int column) {
        return XPADDING + cellSize * column ;
    }
}
