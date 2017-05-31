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

    /**
     * GameObject Constructor
     *
     * @param gridPosition The object's grid position
     * @param gameObjectsType The game object type
     */
    public GameObject(GridPosition gridPosition, GameObjectsType gameObjectsType) {
        this.gridPosition = gridPosition;
        this.type = gameObjectsType;
    }

    /**
     * Get the grid position
     *
     * @return The position
     */
    public GridPosition getGridPosition() {
        return gridPosition;
    }

    /**
     * Get the game object type
     *
     * @return The type
     */
    public GameObjectsType getType() {
        return type;
    }
}
