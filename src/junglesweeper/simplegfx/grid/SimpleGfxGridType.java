package junglesweeper.simplegfx.grid;

import junglesweeper.Level;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public enum SimpleGfxGridType {
    // Paths Priority, xPadding , yPadding , Col , Rows , CellSize //
    INFO_GRID("./assets/Game/sidebarBg.png", 2, 32, 35, -1, -1, 1),
    MAP_GRID("./assets/Game/grid.png", 1, 190, 35, Level.getLevelMatrix(0).length, Level.getLevelMatrix(0)[0].length, 40);


    private int priority;
    private String imagePath;
    private int xPadding;
    private int yPadding;
    private int cols;
    private int rows;
    private int cellSize;

    SimpleGfxGridType(String imagePath, int priority, int xPadding, int yPadding, int cols, int rows, int cellSize) {
        this.priority = priority;
        this.imagePath = imagePath;
        this.xPadding = xPadding;
        this.yPadding = yPadding;
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
    }

    /**
     * Get the priority of the grid
     *
     * @return An int with the priority level
     */
    public int getPriority() {

        return priority;
    }

    /**
     * Get the image path
     *
     * @return A String with the image path
     */
    public String getImagePath() {

        return imagePath;
    }

    /**
     * Get the horizontal padding
     *
     * @return An int with the padding value
     */
    public int getxPadding() {

        return xPadding;
    }

    /**
     * Get the vertical padding
     *
     * @return An int with the padding value
     */
    public int getyPadding() {

        return yPadding;
    }

    /**
     * Get the cell size
     *
     * @return An int with the cell size value
     */
    public int getCellSize() {

        return cellSize;
    }

    /**
     * Get total of columns
     *
     * @return An int with the number of  columns
     */
    public int getCols() {

        return cols;
    }

    /**
     * Get total of rows
     *
     * @return An int with the number of rows
     */
    public int getRows() {

        return rows;
    }
}