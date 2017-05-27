package junglesweeper.collisiondetector;

import junglesweeper.gameobjects.Rock;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;

import java.util.List;

/**
 * Created by fabio on 26/05/2017.
 */
public class CollisionDetector {

    private List<Collidable> objectsList;
    private Player player;

    public CollisionDetector(List<Collidable> objectsList, Player player) {

        this.objectsList = objectsList;
        this.player = player;

    }

    public boolean isPossible(GridPosition pos) {

        for (Collidable c : objectsList) {

            if (c.getPos().equals(pos) && c instanceof Rock) {
                return false;
            }

        }

        return true;

    }

    public boolean check() {

        for (Collidable c : objectsList) {

            if (player.equals(c)) {



            }

        }

        return false;

    }

}
