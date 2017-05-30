package junglesweeper.grid;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by codecadet on 30/05/17.
 */
public class SimpleGfxDisplay implements Display {

    private Grid background;
    private Grid sensorGrid;
    private Grid mapGride;
    private int padding;
    private int numbOfGrids;

    public SimpleGfxDisplay(int padding){
        this.padding = padding;
        numbOfGrids = 3;
    }

    @Override
    public Stack<Grid> getDisplayStack() {
        Stack<Grid> aux = new Stack<>();
        aux.push(background);
        aux.push(sensorGrid);
        aux.push(mapGride);

        return aux;
    }

    public int getNumbOfGrids(){
        return numbOfGrids;
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }
}
