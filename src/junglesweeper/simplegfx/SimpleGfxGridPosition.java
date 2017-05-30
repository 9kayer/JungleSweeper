package junglesweeper.simplegfx;

import junglesweeper.grid.position.AbstractGridPosition;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SimpleGfxGridPosition extends AbstractGridPosition {

    private SimpleGfxGrid simpleGfxGrid;
    private Picture picture;

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid simpleGfxGrid, String imagePath) {
        super(col, row, simpleGfxGrid, imagePath);

        this.simpleGfxGrid = simpleGfxGrid;

        int x = simpleGfxGrid.getX() + col * simpleGfxGrid.getCellSize();
        int y = simpleGfxGrid.getY() + row * simpleGfxGrid.getCellSize();
        this.picture = new Picture(x, y, imagePath);
    }

    @Override
    public void setPos(int col, int row) {
        int lastMoveCol = getCol();
        int lastMoveRow = getRow();

        super.setPos(col, row);

        int dX = simpleGfxGrid.columnToX(getCol()) - simpleGfxGrid.columnToX(lastMoveCol);
        int dY = simpleGfxGrid.rowToY(getRow()) - simpleGfxGrid.rowToY(lastMoveRow);
        picture.translate(dX, dY);
    }

    @Override
    public void show() {
        picture.draw();
    }

    @Override
    public void hide() {
        picture.delete();
    }

    @Override
    public void movingDirection(Direction direction) {
        super.movingDirection(direction);
    }

    @Override
    public boolean equals(GridPosition gridPosition) {

        if (getCol() == gridPosition.getCol() && getRow() == gridPosition.getRow()) {
            return true;
        }

        return false;
    }
}
