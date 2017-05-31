package junglesweeper.sensor;

import junglesweeper.Level;
import junglesweeper.gameobjects.GameObjectsType;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

/*public class Sensor {

    private int col;
    private int row;
    private int[][] myArray;
    private int[][] sensorNumbers;

    public Sensor(int col, int row, int level) {
        this.col = col;
        this.row = row;
        this.myArray = Level.getLevelMatrix(level);
    }

    public void init() {

        sensorNumbers = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sensorNumbers[i][j] = getNeighbors(i, j);
            }
        }
    }

    public void updateLevel(int level) {
        this.myArray = Level.getLevelMatrix(level);
    }

    public int getNeighbors(int i, int j) {
        int objectI = i;
        int objectJ = j;
        int total = 0;

        for (int xoff = -1; xoff <= 1; xoff++) {
            int number = i + xoff;

            if (number < 0 || number >= myArray.length) {
                continue;
            }

            for (int yoff = -1; yoff <= 1; yoff++) {

                if (xoff == -1 && yoff == -1 || xoff == 1 && yoff == -1 || xoff == -1 && yoff == 1 || xoff == 1 && yoff == 1) {
                    continue;
                }

                int number2 = j + yoff;

                if (number2 < 0 || number2 >= myArray.length) {
                    continue;
                }

                GameObjectsType neighbor = GameObjectsType.get(myArray[number][number2]);

                int neighborI = number;
                int neighborJ = number2;

                if (objectI == neighborI && objectJ == neighborJ) {
                    continue;
                }

                if (neighbor.equals(GameObjectsType.TIGER)) {
                    total++;
                }
            }
        }

        return total;
    }

    public int getEnemies(int i, int j) {
        return sensorNumbers[i][j];
    }
}*/

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

        trapsByPosition = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
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

        //TODO: Validate the new sensor solution
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

        /*for (int xoff = -1; xoff <= 1; xoff++) {
            int sonarCol = col + xoff;

            if (sonarCol < 0 || sonarCol >= actualGameMatrix.length) {
                continue;
            }

            for (int yoff = -1; yoff <= 1; yoff++) {

                if (xoff == -1 && yoff == -1 || xoff == 1 && yoff == -1 || xoff == -1 && yoff == 1 || xoff == 1 && yoff == 1) {
                    continue;
                }

                int sonarRow = row + yoff;

                if (sonarRow < 0 || sonarRow >= actualGameMatrix.length) {
                    continue;
                }

                GameObjectsType neighbor = GameObjectsType.translateMapReference(actualGameMatrix[sonarCol][sonarRow]);

                //int neighborI = sonarCol;
                //int neighborJ = sonarRow;

                if (col == sonarCol && row == sonarRow) {
                    continue;
                }

                if (neighbor.equals(GameObjectsType.TIGER)) {
                    total++;
                }
            }
        }*/

        return total;
    }

    public int getEnemies(int col, int row) {
        return trapsByPosition[col][row];
    }
}
