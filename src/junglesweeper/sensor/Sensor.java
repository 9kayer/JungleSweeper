package junglesweeper.sensor;

import junglesweeper.Level;
import junglesweeper.gameobjects.GameObjectsType;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class Sensor {

    private int cols;
    private int rows;
    private int[][] actualGameMatrix;
    private int[][] trapsByPosition;

    /**
     * Sensor Constructor
     *
     * @param cols game matix columns
     * @param rows game matix rows
     * @param level game level
     */
    public Sensor(int cols, int rows, int level) {
        this.cols = cols;
        this.rows = rows;
        this.actualGameMatrix = Level.getLevelMatrix(level);

    }

    /**
     * Initialize the traps matrix
     */
    public void init() {

        trapsByPosition = new int[cols][rows];

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                trapsByPosition[col][row] = getTrapsByPosition(col, row);
            }
        }
    }

    /**
     * Count traps for each position
     *
     * @param level The level number
     */
    public void updateLevel(int level) {
        this.actualGameMatrix = Level.getLevelMatrix(level);
    }

    /**
     * Get traps by each matrix position
     * @param col Receives the column
     * @param row Receives the row
     * @return Total number of traps in the position
     */
    public int getTrapsByPosition(int col, int row) {
        int total = 0;

        if ((col - 1 >= 0) && GameObjectsType.get(actualGameMatrix[col - 1][row]).equals(GameObjectsType.TIGER)) {
            total++;
        }

        if ((col + 1 < cols) && GameObjectsType.get(actualGameMatrix[col + 1][row]).equals(GameObjectsType.TIGER)) {
            total++;
        }

        if ((row - 1 >= 0) && GameObjectsType.get(actualGameMatrix[col][row - 1]).equals(GameObjectsType.TIGER)) {
            total++;
        }

        if ((row + 1 < rows) && GameObjectsType.get(actualGameMatrix[col][row + 1]).equals(GameObjectsType.TIGER)) {
            total++;
        }

        return total;
    }

    /**
     * Get traps for each matrix position
     * @param col Receives the column
     * @param row Receives the row
     * @return The number of traps for the position requested
     */
    public int getEnemies(int col, int row) {
        return trapsByPosition[col][row];
    }
}
