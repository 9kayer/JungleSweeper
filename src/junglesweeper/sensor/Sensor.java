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
     * Sensor logic constructor
     *
     * @param cols   game matix columns
     * @param rows   game matix rows
     * @param level game level
     */
    public Sensor(int cols, int rows, int level) {
        this.cols = cols;
        this.rows = rows;
        this.actualGameMatrix = Level.getLevelMatrix(level);

    }

    public void init() {

        trapsByPosition = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                trapsByPosition[i][j] = getNeighbors(i, j);
            }
        }
    }

    /**
     * Update level
     *
     * @param level
     */
    public void updateLevel(int level) {
        this.actualGameMatrix = Level.getLevelMatrix(level);
    }

    public int getNeighbors(int col, int row) {
        int total = 0;

        if ((col - 1 >= 0) && GameObjectsType.get(actualGameMatrix[col - 1][row]).equals(GameObjectsType.ENEMY)) {
            total++;
        }

        if ((col + 1 < cols) && GameObjectsType.get(actualGameMatrix[col + 1][row]).equals(GameObjectsType.ENEMY)) {
            total++;
        }

        if ((row - 1 >= 0) && GameObjectsType.get(actualGameMatrix[col][row - 1]).equals(GameObjectsType.ENEMY)) {
            total++;
        }

        if ((row + 1 < rows) && GameObjectsType.get(actualGameMatrix[col][row + 1]).equals(GameObjectsType.ENEMY)) {
            total++;
        }

        return total;
    }

    public int getEnemies(int col, int row) {
        return trapsByPosition[col][row];
    }
}
