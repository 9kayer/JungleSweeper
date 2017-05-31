package junglesweeper.gameobjects;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public enum GameObjectsType {

    ROCK(1, "./assets/pictures/rock.png"), //TODO: Can we move here the the GridColor(s)?
    KEY(3, "./assets/pictures/key.png"),
    PATH(5, "./assets/Game/path.png"),
    DOOR(4, "./assets/Game/Door.png"),
    TIGER(2, "./assets/pictures/tiger.png");

    private int referenceInMap; //TODO: Confirm if this property is really needed
    private String imagePath;

    /**
     * GameObjectsType Constructor
     *
     * @param referenceInMap Reference for the level matrix
     * @param imagePath Path for the game objects images
     */
    GameObjectsType(int referenceInMap, String imagePath) {
        this.referenceInMap = referenceInMap;
        this.imagePath = imagePath;
    }

    /**
     * Get the images path
     *
     * @return The path
     */
    public String getImagePath() {

        return imagePath;
    }

    /**
     * Translator for the level grid matrix
     *
     * @param referenceInMap Reference to the game object
     * @return Corresponding game object
     */
    public static GameObjectsType get(int referenceInMap) {

        switch (referenceInMap) {

            case 1:
                return ROCK;
            case 2:
                return TIGER;
            case 3:
                return KEY;
            case 4:
                return DOOR;
            default:
                return ROCK;
        }
    }
}
