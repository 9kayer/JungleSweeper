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
        traps = new Text(50, 50, Integer.toString(trap));
    }

    public void reWrite(int trap) {
        traps.delete();
        traps.setText(Integer.toString(trap));
        //traps = new Text(50, 50, Integer.toString(trap));
        show();
    }

    public void show() {
        traps.draw();
    }
}
