package junglesweeper.sensor;

import junglesweeper.grid.DisplayType;

/**
 * Created by codecadet on 28/05/17.
 */
public class SensorFactory {

    private SensorFactory(DisplayType displayType) {
        switch(displayType){
            case SIMPLE_GFX:
                //return new SimpleGfxSensor();
            default:
                //return new SimpleGfxSensor();
        }
    }
}
