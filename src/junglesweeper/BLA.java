package junglesweeper;

import junglesweeper.grid.CellType;

/**
 * Created by fabio on 26/05/2017.
 */
public class BLA {


    private CellType[][] matrix = new CellType[][]{{CellType.ROCK,CellType.ROCK,CellType.CLEAR,CellType.CLEAR},
                                                    {CellType.ROCK,CellType.ROCK,CellType.CLEAR,CellType.KEY},
                                                    {CellType.CLEAR,CellType.CLEAR,CellType.CLEAR,CellType.TIGER},
                                                    {CellType.ROCK,CellType.CLEAR,CellType.ROCK,CellType.ROCK}};
}
