package junglesweeper.simplegfx;

import junglesweeper.CollisionDetector;
import junglesweeper.Representble;
import junglesweeper.gridposition.GridPosition;
import junglesweeper.player.ControlType;
import junglesweeper.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 27/05/17.
 */
public class SimpleGfxPlayer extends Player implements Representble {
    private Picture picture;
    public final static int SPEED = 1;

    public SimpleGfxPlayer(GridPosition pos, ControlType type, int lives, CollisionDetector collisionDetector) {
        super(pos, type, lives, collisionDetector);

        System.out.println();
        System.out.println(grid.columnToX(getPos().getCol()));
        System.out.println(grid.rowToY(getPos().getRow()));
        this.picture = new Picture(getPos().getCol(), getPos().getRow(), "assets/King.png");
        show();
    }

    public void move() {
        int lastMoveCol = getPos().getCol();
        int lastMoveRow = getPos().getRow();
        accelerate();
        int dX = grid.columnToX(getPos().getCol()) - grid.columnToX(lastMoveCol);
        int dY = grid.rowToY(getPos().getRow()) - grid.rowToY(lastMoveRow);
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
}
