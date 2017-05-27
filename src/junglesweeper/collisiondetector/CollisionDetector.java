package junglesweeper.collisiondetector;

import junglesweeper.gameobjects.Key;
import junglesweeper.gameobjects.Rock;
import junglesweeper.gameobjects.Tiger;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 26/05/2017.
 */
public class CollisionDetector {

    private ArrayList<ArrayList> objectsList;
    private Player player;

    public CollisionDetector(ArrayList<ArrayList> objectsList) {

        this.objectsList = objectsList;

    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isPossible(GridPosition pos) {

        for (ArrayList<Collidable> c : objectsList) {

            for (Collidable e : c) {

                if (e instanceof Rock && e.getPos().equals(pos)) {
                    return false;
                }

            }

        }

        return true;

    }

    public boolean check() {

        /*for (Collidable c : objectsList) {

            if (player.equals(c)) {

                if (c instanceof Key) {
                    player.collectKey();
                    c.collide();
                }

                if (c instanceof Tiger) {
                    // TODO implement action for colliding with tiger
                }

                return true;

            }

        }*/

        return false;

    }

}
