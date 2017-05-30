package junglesweeper.sensor;

import junglesweeper.grid.GridType;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SensorFactory {

    private SensorFactory(GridType gridType) {
        switch(gridType){
            case SIMPLE_GFX:
                //return new SimpleGfxSensor();
            default:
                //return new SimpleGfxSensor();
        }
    }
}
