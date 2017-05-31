package junglesweeper.simplegfx.grid;

/**
 * Created by codecadet on 30/05/17.
 */
public enum SimpleGfxGridType {
    // Paths Priority, xPadding , yPadding , Col , Rows , CellSize //
    INFO_GRID("./assets/Game/sidebarBg.png", 2, 32, 35, -1, -1, 1),
    MAP_GRID("./assets/Game/grid.png", 1, 190, 35, 17, 17, 40);


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