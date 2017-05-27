package junglesweeper;

import junglesweeper.grid.Grid;
import junglesweeper.grid.GridFactory;
import junglesweeper.grid.GridType;
import junglesweeper.simplegfx.SimpleGfxGrid;
import junglesweeper.simplegfx.SimpleGfxGridPosition;

import java.util.ArrayList;

/**
 * Created by fabio on 26/05/2017.
 */
public class Game {

    private CollisionDetector collisionDetector;
    private ArrayList<ArrayList> gameObjectList;
    private Grid grid;
    private int delay;

    public Game (GridType gridType, int cols, int rows, int delay){
        grid = GridFactory.makeGrid(gridType, cols, rows);
        gameObjectList = new ArrayList<ArrayList>();
        for(int i = 0; i < cols; i++){
            gameObjectList.add(new ArrayList< SimpleGfxGridPosition>());
        }
        this.delay = delay;
    }

    public void init(){
        grid.init();

        System.out.println("AQUI");
        System.out.println(grid.getCols());
        for (int i = 0; i < grid.getCols(); i++){
            System.out.println("i: " + Integer.toString(i));
            for (int j = 0; j < grid.getRows(); j++){
                System.out.println("j: " + Integer.toString(j));
                gameObjectList.get(i).add(new SimpleGfxGridPosition(i,j,GridColor.values()[(int)(Math.random() * GridColor.values().length)],(SimpleGfxGrid) grid));
            }
        }


    }

    public void start(){

    }

    public void movePlayer(){

    }

}
