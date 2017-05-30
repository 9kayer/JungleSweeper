package junglesweeper.grid;

/**
 * Created by fabio on 26/05/2017.
 */
public enum DisplayType {

    SIMPLE_GFX("./assets/pictures/grid.png");

    private String imagePath;

    DisplayType(String string){
        imagePath = string;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
