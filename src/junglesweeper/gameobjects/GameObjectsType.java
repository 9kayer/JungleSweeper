package junglesweeper.gameobjects;

import junglesweeper.GridColor;

/**
 * Created by codecadet on 26/05/17.
 */
public enum GameObjectsType {

    ROCK(GridColor.GRAY, "\n   R", 1),
    KEY(GridColor.YELLOW, "\n   K", 3),
    PATH(GridColor.MAGENTA, "\n   B", 5),
    DOOR(GridColor.BLACK, "\n   D", 4),
    TIGER(GridColor.RED, "\n   T", 2);

    private GridColor color;
    private String text;
    private int referenceInMap;

    GameObjectsType(GridColor color, String text, int referenceInMap) {
        this.color = color;
        this.text = text;
        this.referenceInMap = referenceInMap;
    }

    public GridColor getColor() {
        return color;
    }

    public String getText() {
        return text;
    }


    public void setColor(GridColor color) {
        this.color = color;
    }

    public static GameObjectsType translateMapReference(int referenceInMap){

        switch (referenceInMap){
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
