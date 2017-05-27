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

    private Rectangle rectangle;
    private Text text;
    private SimpleGfxGrid simpleGfxGrid;

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid simpleGfxGrid) {

        super(col, row, simpleGfxGrid);

        int x = SimpleGfxGrid.X_PADDING + col * simpleGfxGrid.getCellSize();
        int y = SimpleGfxGrid.Y_PADDING + row * simpleGfxGrid.getCellSize();

        this.rectangle = new Rectangle(x, y, simpleGfxGrid.getCellSize(), simpleGfxGrid.getCellSize());

        this.simpleGfxGrid = simpleGfxGrid;

        text = new Text(x, y, "\n   a");
        text.setColor(SimpleGfxColorMapper.getColor(GridColor.BLACK));

        show();
    }

    @Override
    public void setColor(GridColor color) {
        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
    }

    @Override
    public void setPos(int col, int row) {
        super.setPos(col, row);
    }

    @Override
    public void setText(String text) {
        this.text.setText(text);
    }

    @Override
    public void show() {
        rectangle.fill();
        text.draw();
    }

    @Override
    public void hide() {
        rectangle.delete();
    }

    @Override
    public void movingDirection(Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(GridPosition gridPosition) {
        throw new UnsupportedOperationException();
    }
}