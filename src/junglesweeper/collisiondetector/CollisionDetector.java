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

    /**
     * Collision Detector initialization
     *
     * @param objectsList Receives the list of game objects
     * @param player Receives the game player
     */
    public void init(ArrayList<? extends Collidable> objectsList, Player player) {

        this.objectsList = new ArrayList<>(objectsList);
        this.player = player;
    }

    /**
     * Evaluation of the position
     *
     * @param gridPosition Receives a grid position
     * @return A boolean
     */
    public boolean isPossible(GridPosition gridPosition) {

        for (Collidable object : objectsList) {

            if (object instanceof Rock && object.getPos().equals(gridPosition)) {

                return false;
            }
            if (!player.hasKey() && object instanceof Door && object.getPos().equals(gridPosition)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Evaluate collision with the key, tiger, door or path
     * @return The collision object otherwise null
     */
    public Collidable collision() {

        for (Collidable object : objectsList) {

            if (!player.getPos().equals(object.getPos())) {

                continue;
            }

            if (object instanceof Key && object.isActive()) {
                object.collide();
                player.collectKey();

                return object;
            }

            if (object instanceof Tiger) {
                player.collide();
                player.reset();
                player.getPos().show();

                return object;
            }

            if (object instanceof Door && player.hasKey()) {
                object.collide();

                return object;
            }

            if (object instanceof Path) {
                object.collide();
            }
        }

        return null;
    }
}
