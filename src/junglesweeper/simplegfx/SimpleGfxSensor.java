package junglesweeper.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class SimpleGfxSensor {

    private Picture pic;

    public SimpleGfxSensor(int trap) {
        pic = new Picture(85, 65, "./assets/pictures/SliderBarNone.png");
    }

    //Change image by the number of enemys around

    public void reWrite(int trap) {
        switch (trap) {
            case 0:
                pic.load("./assets/pictures/SliderBarNone.png");
                break;
            case 1:
                pic.load("./assets/pictures/SliderBarBlue.png");
                break;
            case 2:
                pic.load("./assets/pictures/SliderBarOrange.png");
                break;
            case 3:
                pic.load("./assets/pictures/SliderBarRed.png");
                break;
        }
    }

    public void show() {
        pic.draw();
    }

    public void hide(){
        pic.delete();
    }
}
