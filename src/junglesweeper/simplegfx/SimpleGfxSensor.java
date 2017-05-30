package junglesweeper.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SimpleGfxSensor {

    private Text traps;

    public SimpleGfxSensor(int trap) {
        traps = new Text(10, 10, Integer.toString(trap));
        show();
    }

    public void reWrite(int trap) {
        traps.delete();
        traps = new Text(10, 10, Integer.toString(trap));
        show();
    }

    public void show() {
        traps.draw();
    }
}
