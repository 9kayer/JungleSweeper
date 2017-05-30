package junglesweeper.simplegfx.grid;

/**
 * Created by codecadet on 30/05/17.
 */
public enum SimpleGfxGridType {
    MAP_GRID("./assets/pictures/grid.png", 1, 190, 35, 17, 17, 40),
    INFO_GRID("./assets/pictures/sensor.png", 2, 32, 35, -1, -1, 1);

    private int priority;
    private String imagePath;
    private int xPadding;
    private int yPadding;
    private int cols;
    private int rows;
    private int cellSize;

    SimpleGfxGridType(String imagePath, int priority, int xPadding, int yPadding, int cols, int rows, int cellSize) {
        this.priority= priority;
        this.imagePath = imagePath;
        this.xPadding = xPadding;
        this.yPadding = yPadding;
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
    }

    public int getPriority() {
        return priority;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getxPadding() {
        return xPadding;
    }

    public int getyPadding() {
        return yPadding;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}