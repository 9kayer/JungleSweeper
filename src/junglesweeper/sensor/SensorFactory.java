package junglesweeper.sensor;

import junglesweeper.grid.DisplayType;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SensorFactory {

    private SensorFactory(DisplayType displayType) {

        switch (displayType) {
            case SIMPLE_GFX:
                //return new SimpleGfxSensor();
            default:
                //return new SimpleGfxSensor();
        }
    }
}
