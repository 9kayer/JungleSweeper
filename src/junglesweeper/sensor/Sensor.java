package junglesweeper.sensor;

import junglesweeper.Level;
import junglesweeper.gameobjects.GameObject;
import junglesweeper.gameobjects.GameObjectsType;

/**
 * Created by codecadet on 27/05/17.
 */
public class Sensor {

    private int col;
    private int row;
    private int[][] myArray;
    private int[][] sensorNumbers;

    public Sensor(int col, int row, int i) {
        this.col = col;
        this.row = row;
        this.myArray = Level.getLevelMatrix(i);
    }

    public void init() {

        sensorNumbers = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sensorNumbers[i][j] = getNeibours(i, j);

            }
        }

    }

    public void updateLevel(int i) {
        this.myArray = Level.getLevelMatrix(i);
    }

    public int getNeibours(int i, int j) {
        int objectI = i;
        int objectJ = j;
        int total = 0;

        for (int xoff = -1; xoff <= 1; xoff++) {
            int number = i + xoff;
            if (number < 0 || number >= myArray.length) continue;
            for (int yoff = -1; yoff <= 1; yoff++) {
                if (xoff == -1 && yoff == -1 || xoff == 1 && yoff == -1 || xoff == -1 && yoff == 1 || xoff == 1 && yoff == 1)
                    continue;
                int number2 = j + yoff;
                if (number2 < 0 || number2 >= myArray.length) continue;

                GameObjectsType neighbor = GameObjectsType.translateMapReference(myArray[number][number2]);

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

    public int getEnemys(int i, int j) {
        return sensorNumbers[i][j];
    }
}
