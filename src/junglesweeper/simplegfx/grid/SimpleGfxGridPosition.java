package junglesweeper.simplegfx.grid;


import junglesweeper.grid.position.AbstractGridPosition;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.simplegfx.grid.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by fabio on 26/05/2017.
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
    public boolean equals(GridPosition g) {
        if (getCol() == g.getCol() && getRow() == g.getRow()) {
            return true;
        }

        return false;
    }

    public SimpleGfxGrid getSimpleGfxGrid() {
        return simpleGfxGrid;
    }

    public void setPicture(String str) {
        picture.load(str);
    }

}
