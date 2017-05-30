package junglesweeper.gameobjects;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public enum GameObjectsType {

    ROCK(1, "./assets/pictures/rock.png" ), //TODO: Can we move here the the GridColor(s)?
    KEY(3, "./assets/pictures/key.png"),
    PATH(5, "./assets/pictures/path.jpeg"),
    DOOR(4, "./assets/pictures/door.png"),
    TIGER(2, "./assets/pictures/tiger.png");

    private int referenceInMap; //TODO: Confirm if this property is really needed
    private String imagePath;

    GameObjectsType(int referenceInMap, String imagePath) {
        this.referenceInMap = referenceInMap;
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    // Translator for the level grid matrix
    public static GameObjectsType translateMapReference(int referenceInMap) {

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
                System.out.println("Default GameObjectsType");
                return ROCK;
        }
    }
}
