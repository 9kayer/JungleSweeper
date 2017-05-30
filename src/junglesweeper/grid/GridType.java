package junglesweeper.grid;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public enum GridType {

    SIMPLE_GFX("./assets/pictures/grid.png");

    private String imagePath;

    GridType(String string) {
        imagePath = string;
    }

    public String getImagePath() {
        return imagePath;
    }
}
