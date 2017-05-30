package junglesweeper.simplegfx;


import junglesweeper.GridColor;
import junglesweeper.grid.position.AbstractGridPosition;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by fabio on 26/05/2017.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private SimpleGfxGrid simpleGfxGrid;
    //private Rectangle rectangle;
    private Picture picture;

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid simpleGfxGrid, String imagePath) {
        super(col, row, simpleGfxGrid, imagePath);

        this.simpleGfxGrid = simpleGfxGrid;

        int x = simpleGfxGrid.getX() + col * simpleGfxGrid.getCellSize();
        int y = simpleGfxGrid.getY() + row * simpleGfxGrid.getCellSize();

        //this.rectangle = new Rectangle(x, y, simpleGfxGrid.getCellSize(), simpleGfxGrid.getCellSize());
        this.picture = new Picture(x, y, imagePath);
        show();
    }

    @Override
    public void setLayout(GridColor color) {
        super.setLayout(color);
        //rectangle.setColor(SimpleGfxColorMapper.getColor(color));
    }

    @Override
    public void setPos(int col, int row) {
        int lastMoveCol = getCol();
        int lastMoveRow = getRow();

        super.setPos(col, row);

        int dX = simpleGfxGrid.columnToX(getCol()) - simpleGfxGrid.columnToX(lastMoveCol);
        int dY = simpleGfxGrid.rowToY(getRow()) - simpleGfxGrid.rowToY(lastMoveRow);
        //rectangle.translate(dX, dY);
        picture.translate(dX, dY);
    }

    @Override
    public void show() {
        //rectangle.fill();
        picture.draw();
    }

    @Override
    public void hide() {
        //rectangle.delete();
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



}
