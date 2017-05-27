package junglesweeper.simplegfx;


import junglesweeper.GridColor;
import junglesweeper.gridposition.AbstractGridPosition;
import junglesweeper.gridposition.Direction;
import junglesweeper.gridposition.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by fabio on 26/05/2017.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    public SimpleGfxGridPosition(int col, int row, GridColor color, SimpleGfxGrid simpleGfxGrid) {

        super(col, row, color, simpleGfxGrid);

        int x = SimpleGfxGrid.XPADDING + col * simpleGfxGrid.getCellSize();

        int y = SimpleGfxGrid.YPADDING + row * simpleGfxGrid.getCellSize();

        this.rectangle = new Rectangle(x,y, simpleGfxGrid.getCellSize(),simpleGfxGrid.getCellSize());
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        this.simpleGfxGrid = simpleGfxGrid;
        show();
    }

    @Override
    public void setPos(int col, int row) {
        super.setPos(col,row);
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

    }

    @Override
    public boolean equals(GridPosition gridPosition) {
        return false;
    }
}
