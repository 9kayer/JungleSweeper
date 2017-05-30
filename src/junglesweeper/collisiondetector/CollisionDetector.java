package junglesweeper.collisiondetector;

import junglesweeper.gameobjects.*;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;

import java.util.ArrayList;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class CollisionDetector {

    private ArrayList<Collidable> objectsList;
    private Player player;

    public void init(ArrayList<? extends Collidable> objectsList, Player player) {
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

    public Collidable collision() {

        for (Collidable c : objectsList) {

            if (!player.getPos().equals(c.getPos())) {
                continue;
            }

            if (c instanceof Key && c.isActive()) {
                System.out.println("Key");
                c.collide();
                player.collectKey();

                return c;
            }

            if (c instanceof Tiger) {
                System.out.println("Tiger");
                player.collide();
                player.reset();
                player.getPos().show();

                return c;
            }

            if (c instanceof Door && player.hasKey()) {
                System.out.println("Door");
                c.collide();

                return c;
            }

            if (c instanceof Path) {
                c.collide();
            }

        }

        return null;

    }
}
