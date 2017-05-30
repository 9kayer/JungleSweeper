package junglesweeper.grid;

/**
 * Created by codecadet on 30/05/17.
 */
public class DisplayFactory {

    public static Display makeDisplay(DisplayType displayType, int padding){
        switch(displayType){
            case SIMPLE_GFX:
                return new SimpleGfxDisplay(displayType, padding);
            default:
                return new SimpleGfxDisplay(displayType, padding);
        }
    }
}
