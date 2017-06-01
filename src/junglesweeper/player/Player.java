package junglesweeper.player;

import junglesweeper.collisiondetector.Collidable;
import junglesweeper.collisiondetector.CollisionDetector;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.grid.position.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public abstract class Player implements Collidable {

    private GridPosition pos;
    private boolean key;
    private int lives;
    private Picture keyPic;
    private CollisionDetector collisionDetector;

    // Initialize our Player
    public Player(GridPosition pos, int lives, CollisionDetector collisionDetector) {
        this.pos = pos;
        this.lives = lives;
        this.collisionDetector = collisionDetector;
        keyPic = new Picture(110 , 320,"./assets/Game/nokey.png");
    }

    public boolean hasKey() {
        return key;
    }

    public void collectKey() {
        keyPic.load("./assets/Game/key.png");
        key = true;
    }

    public void dropKey() {
        keyPic.load("./assets/Game/nokey.png");
        key = false;
    }


    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

    public abstract boolean move(Direction direction);

    public abstract void show();

    public void keyPicShow(){
        keyPic.draw();
    }

    @Override
    public void collide() {
        lives--;
    }

    @Override
    public boolean isActive() {
        return lives > 0;
    }

    @Override
    public GridPosition getPos() {
        return pos;
    }

    public int getLives() {
        return lives;
    }
}
