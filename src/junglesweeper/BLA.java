package junglesweeper;

import junglesweeper.grid.CellType;

/**
 * Created by fabio on 26/05/2017.
 */
public class BLA {


    private CellType[][] matrix = new CellType[][]{{CellType.ROCK,CellType.ROCK,CellType.EMPTY,CellType.EMPTY},
                                                    {CellType.ROCK,CellType.ROCK,CellType.EMPTY,CellType.KEY},
                                                    {CellType.EMPTY,CellType.EMPTY,CellType.EMPTY,CellType.TIGER},
                                                    {CellType.ROCK,CellType.EMPTY,CellType.ROCK,CellType.ROCK}};
}
