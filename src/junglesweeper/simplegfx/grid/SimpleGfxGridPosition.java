package junglesweeper.simplegfx.grid;

import junglesweeper.grid.position.AbstractGridPosition;
import junglesweeper.grid.position.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SimpleGfxGridPosition extends AbstractGridPosition {

    private SimpleGfxGrid simpleGfxGrid;
    private Picture picture;

    /**
     * SimpleGfx grid position
     *
     * @param col Receive column
     * @param row Receive row
     * @param simpleGfxGrid SimpleGfx grid
     * @param imagePath Image path for each position
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid simpleGfxGrid, String imagePath) {
        super(col, row, simpleGfxGrid, imagePath);

        this.simpleGfxGrid = simpleGfxGrid;

        int x = simpleGfxGrid.getX() + col * simpleGfxGrid.getCellSize();
        int y = simpleGfxGrid.getY() + row * simpleGfxGrid.getCellSize();
        this.picture = new Picture(x, y, imagePath);
    }

    /**
     * Set a position in the grid
     *
     * @param col Column
     * @param row Row
     */
    @Override
    public void setPos(int col, int row) {
        int lastMoveCol = getCol();
        int lastMoveRow = getRow();

        super.setPos(col, row);

        int dX = simpleGfxGrid.columnToX(getCol()) - simpleGfxGrid.columnToX(lastMoveCol);
        int dY = simpleGfxGrid.rowToY(getRow()) - simpleGfxGrid.rowToY(lastMoveRow);
        picture.translate(dX, dY);
    }

    /**
     * Draw the image (border)
     */
    @Override
    public void show() {
        picture.draw();
    }

    /**
     * Hide the image
     */
    @Override
    public void hide() {
        picture.delete();
    }

    /**
     * Direction of the move
     *
     * @param direction Receives a direction to move
     */
    @Override
    public void movingDirection(Direction direction) {
        super.movingDirection(direction);
    }

    /**
     * Get the SimpleGfx grid
     *
     * @return The a SimpleGfx grid
     */
    public SimpleGfxGrid getSimpleGfxGrid() {

        return simpleGfxGrid;
    }

    /**
     * Set the picture
     *
     * @param str Receives a String
     */
    public void setPicture(String str) {

        picture.load(str);
    }

}
