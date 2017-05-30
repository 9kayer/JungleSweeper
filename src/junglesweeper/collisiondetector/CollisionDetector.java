package junglesweeper.collisiondetector;

import junglesweeper.gameobjects.*;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fabio on 26/05/2017.
 */
public class CollisionDetector {

    private ArrayList<Collidable> objectsList;
    private Player player;
    private boolean isDoorOpen;

    public void init(ArrayList<GameObject> objectsList, Player player) {
        this.objectsList = new ArrayList<>(objectsList);
        this.player = player;
    }

    public boolean isPossible(GridPosition pos) {
        for (Collidable c : objectsList) {
            if (c instanceof Rock && c.getPos().equals(pos)) {
                System.out.println("Rock");
                return false;
            }
        }

        return true;
    }

    public boolean collision() {
        for (Collidable c : objectsList) {
            if (!player.getPos().equals(c.getPos())) {
                continue;
            }

            if (c instanceof Key) {
                System.out.println("Key");
                c.collide();
                player.collectKey();
            }

            if (c instanceof Tiger) {
                player.collide();
                player.reset();
                System.out.println(player.getLives());
            }

            if (c instanceof Door && player.hasKey()) {
                System.out.println("Door");
                c.collide();
                isDoorOpen = true;
            }

            if (c instanceof Path) {
                c.collide();
            }

            return true;
        }

        return false;
    }

    public boolean isDoorOpen(){
        return isDoorOpen;
    }

    public void closeDoor() {
        isDoorOpen = false;
    }

}
