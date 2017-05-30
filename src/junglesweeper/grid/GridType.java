package junglesweeper.grid;

/**
 * Created by fabio on 26/05/2017.
 */
public enum GridType {

    SIMPLE_GFX("./assets/pictures/grid.png");

    private String imagePath;

    GridType(String string){
        imagePath = string;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
