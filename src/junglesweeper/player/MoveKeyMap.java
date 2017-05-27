package org.academiadecodigo.bootcamp.controls;

import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * <Academia de Código_>
 * Created by André Martins <Code Cadet>
 * Project CarCrashX (23/05/17)
 */
public class MoveKeyMap implements KeyboardHandler {

    private static final int[] KEYS_1 = {
            KeyboardEvent.KEY_UP,
            KeyboardEvent.KEY_RIGHT,
            KeyboardEvent.KEY_DOWN,
            KeyboardEvent.KEY_LEFT,
            KeyboardEvent.KEY_SPACE
    };

    private static final int[] KEYS_2 = {
            KeyboardEvent.KEY_W,
            KeyboardEvent.KEY_D,
            KeyboardEvent.KEY_S,
            KeyboardEvent.KEY_A,
            KeyboardEvent.KEY_Q
    };

    private int[] keys;
    private Keyboard keyboard;
    private GridDirection direction;
    private boolean moving;
    private boolean specialMove;

    /**
     * Constructor
     */
    public MoveKeyMap(ControlType type) {

        switch (type) {
            case MODE_1:
                keys = KEYS_1;
                break;
            case MODE_2:
                keys = KEYS_2;
                break;
        }

        keyboard = new Keyboard(this);
        direction = GridDirection.UP;
        moving = false;
        specialMove = false;

    }

    public void init() {

        // Direction keys
        for (int i = 0; i < keys.length - 1; i++) {

            addKeyboardEvent(keys[i], KeyboardEventType.KEY_PRESSED);
            addKeyboardEvent(keys[i], KeyboardEventType.KEY_RELEASED);

        }

        // Special key
        addKeyboardEvent(keys[keys.length - 1], KeyboardEventType.KEY_PRESSED);

    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        moving = true;

        // Up or W
        if (e.getKey() == keys[0]) {
            direction = GridDirection.UP;
        }

        // Right or D
        if (e.getKey() == keys[1]) {
            direction = GridDirection.RIGHT;
        }

        // Down or S
        if (e.getKey() == keys[2]) {
            direction = GridDirection.DOWN;
        }

        // Left or A
        if (e.getKey() == keys[3]) {
            direction = GridDirection.LEFT;
        }

        // Space or Q
        if (e.getKey() == keys[4]) {
            specialMove = true;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        moving = false;
        specialMove = false;

    }

    /**
     * Get the direction for the car to use
     *
     * @return direction
     */
    public GridDirection getDirection() {
        return direction;
    }

    /**
     * Flag for moving the car
     *
     * @return boolean
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * Flag for turbo
     *
     * @return boolean
     */
    public boolean isSpecialMove() {
        return specialMove;
    }

    /**
     * Add a keyboard event
     *
     * @param key  to map
     * @param type of click
     */
    private void addKeyboardEvent(int key, KeyboardEventType type) {

        KeyboardEvent temp = new KeyboardEvent();
        temp.setKey(key);
        temp.setKeyboardEventType(type);

        keyboard.addEventListener(temp);

    }

}
