package junglesweeper;

import junglesweeper.gameobjects.GameObject;
import junglesweeper.gameobjects.GameObjectsType;

/**
 * Created by codecadet on 27/05/17.
 */
public class Level {

    private GameObjectsType[][] levelMatrix;

    public Level (){

        GameObjectsType R = GameObjectsType.ROCK;
        GameObjectsType B = GameObjectsType.BUSH;
        GameObjectsType K = GameObjectsType.KEY;
        GameObjectsType T = GameObjectsType.TIGER;
        GameObjectsType D = GameObjectsType.DOOR;



        levelMatrix = new GameObjectsType[][] {}
    }

}
