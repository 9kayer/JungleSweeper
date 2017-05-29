package junglesweeper.sensor;

import junglesweeper.grid.GridType;
import junglesweeper.simplegfx.SimpleGfxGrid;
import junglesweeper.simplegfx.SimpleGfxSensor;

/**
 * Created by codecadet on 28/05/17.
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
