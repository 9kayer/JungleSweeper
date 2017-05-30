package junglesweeper.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by codecadet on 28/05/17.
 */
public class SimpleGfxSensor {

    private Text traps;

    public SimpleGfxSensor(int trap){

        traps = new Text(10,10, Integer.toString(trap));
        show();
    }

    public void reWrite(int trap){
        traps.delete();
        traps = new Text(10,10, Integer.toString(trap));
        show();
    }

    public void show() {
        traps.draw();
    }

}
