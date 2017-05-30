package junglesweeper.gameobjects;

import junglesweeper.collisiondetector.Collidable;
import junglesweeper.grid.position.GridPosition;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public abstract class GameObject implements Collidable {

    private GridPosition gridPosition;
    private GameObjectsType type;

    public GameObject(GridPosition gridPosition, GameObjectsType gameObjectsType) {
        this.gridPosition = gridPosition;
        this.type = gameObjectsType;
    }
    
    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public GameObjectsType getType() {
        return type;
    }
}
