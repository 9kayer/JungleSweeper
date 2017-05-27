package junglesweeper.gameobjects;

import junglesweeper.GridColor;

/**
 * Created by codecadet on 26/05/17.
 */
public enum GameObjectsType {

    ROCK(GridColor.GRAY, "\n   R"),
    KEY(GridColor.YELLOW, "\n   K"),
    BUSH(GridColor.GREEN, "\n   B"),
    DOOR(GridColor.BLACK, "\n   D"),
    TIGER(GridColor.RED, "\n   T");

    private GridColor color;
    private String text;

    GameObjectsType(GridColor color, String text) {
        this.color = color;
        this.text = text;
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
}
