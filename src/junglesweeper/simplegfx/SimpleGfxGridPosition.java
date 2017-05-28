package junglesweeper.simplegfx;


import junglesweeper.GridColor;
import junglesweeper.grid.position.AbstractGridPosition;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by fabio on 26/05/2017.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private SimpleGfxGrid simpleGfxGrid;
    private Rectangle rectangle;

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid simpleGfxGrid) {

        super(col, row, simpleGfxGrid);

        this.simpleGfxGrid = simpleGfxGrid;

        int x = simpleGfxGrid.getX() + col * simpleGfxGrid.getCellSize();
        int y = simpleGfxGrid.getY() + row * simpleGfxGrid.getCellSize();

        this.rectangle = new Rectangle(x, y, simpleGfxGrid.getCellSize(), simpleGfxGrid.getCellSize());

        show();
    }

    @Override
    public void setColor(GridColor color) {
        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
    }

    @Override
    public void setPos(int col, int row) {

        int lastMoveCol = getCol();
        int lastMoveRow = getRow();

        super.setPos(col, row);

        int dX = simpleGfxGrid.columnToX(getCol()) - simpleGfxGrid.columnToX(lastMoveCol);
        int dY = simpleGfxGrid.rowToY(getRow()) - simpleGfxGrid.rowToY(lastMoveRow);
        System.out.println(dX + " "  + dY);
        rectangle.translate(dX, dY);
    }


    @Override
    public void show() {
        rectangle.fill();
    }

    @Override
    public void hide() {
        rectangle.delete();
    }

    @Override
    public void movingDirection(Direction direction) {

        System.out.println(direction);

        //int lastMoveCol = getCol();
        //int lastMoveRow = getRow();

        super.movingDirection(direction);
        /*
        int dX = simpleGfxGrid.columnToX(getCol()) - simpleGfxGrid.columnToX(lastMoveCol);
        int dY = simpleGfxGrid.rowToY(getRow()) - simpleGfxGrid.rowToY(lastMoveRow);
        System.out.println(dX + " "  + dY);
        rectangle.translate(dX, dY);*/

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
