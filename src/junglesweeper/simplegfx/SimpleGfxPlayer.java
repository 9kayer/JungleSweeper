package junglesweeper.simplegfx;

import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.Grid;
import junglesweeper.grid.position.Direction;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;

/**
 * Created by codecadet on 27/05/17.
 */
public class SimpleGfxPlayer extends Player {

    private SimpleGfxGridPosition pos;

    public SimpleGfxPlayer(Grid grid, GridPosition pos, int lives, CollisionDetector collisionDetector) {
        super(grid, pos, lives, collisionDetector);
        this.pos = (SimpleGfxGridPosition) pos;
    }

    public void move(Direction direction) {

        int col = pos.getCol();
        int row = pos.getRow();

        switch (direction) {
            case UP:
                row--;
                break;
            case RIGHT:
                col++;
                break;
            case DOWN:
                row++;
                break;
            case LEFT:
                col--;
                break;
        }

        System.out.println(col);
        System.out.println(row);

        //System.out.println(getCollisionDetector().isPossible(pos));

        //if (getCollisionDetector().isPossible(new SimpleGfxGridPosition(col, row, pos.getSimpleGfxGrid()))) {
            this.pos.movingDirection(direction);
        //}
    }

    public GridPosition getPos() {
        return pos;
    }
}
