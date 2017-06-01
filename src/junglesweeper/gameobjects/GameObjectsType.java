package junglesweeper.gameobjects;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public enum GameObjectsType {

    OBSTACLE(1, "resources/pictures/tree.png" ),
    KEY(3, "resources/pictures/key.png"),
    PATH(5, "resources/pictures/path.png"),
    DOOR(4, "resources/pictures/Door.png"),
    ENEMY(2, "resources/pictures/tiger.png");

    private int referenceInMap;
    private String imagePath;

    GameObjectsType(int referenceInMap, String imagePath) {
        this.referenceInMap = referenceInMap;
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    // Translator for the level grid matrix
    public static GameObjectsType get(int referenceInMap) {

        switch (referenceInMap) {
            case 1:
                return OBSTACLE;
            case 2:
                return ENEMY;
            case 3:
                return KEY;
            case 4:
                return DOOR;
            default:
                return OBSTACLE;
        }
    }
}
