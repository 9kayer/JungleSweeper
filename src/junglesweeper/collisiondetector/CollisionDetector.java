package junglesweeper.collisiondetector;

import junglesweeper.gameobjects.*;
import junglesweeper.grid.position.GridPosition;
import junglesweeper.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 26/05/2017.
 */
public class CollisionDetector {

    private ArrayList<ArrayList> objectsList;

    public CollisionDetector(ArrayList<ArrayList> objectsList) {
        this.objectsList = objectsList;
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

    public boolean collision(Player player) {

        for (ArrayList<Collidable> c : objectsList) {

            for (Collidable e : c) {

                if (player.getPos().equals(e.getPos())) {

                    if (e instanceof Key) {
                        System.out.println("Key");
                        e.collide();
                        player.collectKey();
                    }

                    if (e instanceof Tiger) {
                        System.out.println("Tiger");
                    }

                    if (e instanceof Door) {
                        System.out.println("Door");
                    }
                    if( e instanceof Path){
                        e.collide();
                    }


                    return true;
                }

            }

        }

        return false;

    }

}
