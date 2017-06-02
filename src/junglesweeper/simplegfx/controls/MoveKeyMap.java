package junglesweeper.simplegfx.controls;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import junglesweeper.grid.position.Direction;

/**
 * A/C - bootcamp8
 * Project: JungleSweeper
 * Created by: andre martins, fabio fernandes, joao fazenda, nelson pereira, paulo sousa.
 */

public class MoveKeyMap implements KeyboardHandler {

    private static final int[] KEYS_1 = {
            KeyboardEvent.KEY_UP,
            KeyboardEvent.KEY_RIGHT,
            KeyboardEvent.KEY_DOWN,
            KeyboardEvent.KEY_LEFT,
            KeyboardEvent.KEY_SPACE,
            KeyboardEvent.KEY_N
    };

    private static final int[] KEYS_2 = {
            KeyboardEvent.KEY_W,
            KeyboardEvent.KEY_D,
            KeyboardEvent.KEY_S,
            KeyboardEvent.KEY_A,
            KeyboardEvent.KEY_Q,
            KeyboardEvent.KEY_N
    };

    private int[] keys;
    private Keyboard keyboard;
    private Direction direction;
    private boolean moving;
    private boolean spaceKey;
    private boolean leave;
    private boolean directionKeyBlocked;
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
        direction = Direction.UP;
        moving = false;
        directionKeyBlocked = true;

    }

    public void init() {

        // Direction keys
        for (int i = 0; i < keys.length; i++) {

            addKeyboardEvent(keys[i], KeyboardEventType.KEY_PRESSED);
            addKeyboardEvent(keys[i], KeyboardEventType.KEY_RELEASED);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        // Space or Q
        if (e.getKey() == keys[4] && directionKeyBlocked && !spaceKey) {

            spaceKey = true;
        }

        // N (its common for both because it's the button for leaving the game
        if (e.getKey() == keys[5] && directionKeyBlocked && !leave) {
            leave = true;
        }

        if (directionKeyBlocked) {
            return;
        }

        // Up or W
        if (e.getKey() == keys[0]) {
            moving = true;
            direction = Direction.UP;
        }

        // Right or D
        if (e.getKey() == keys[1]) {
            moving = true;
            direction = Direction.RIGHT;
        }

        // Down or S
        if (e.getKey() == keys[2]) {
            moving = true;
            direction = Direction.DOWN;
        }

        // Left or A
        if (e.getKey() == keys[3]) {
            moving = true;
            direction = Direction.LEFT;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        moving = false;
    }

    /**
     * Get the direction for the player to use
     *
     * @return direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Flag for moving the player
     *
     * @return boolean
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * Stop moving the player
     */
    public void stopMoving() {
        moving = false;
    }

    /**
     * Flag to start the game
     *
     * @return boolean
     */
    public boolean isSpaceKey() {
        return spaceKey;
    }

    public void endSpace(){
        spaceKey = false;
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

    public boolean isDirectionKeyBlocked() {
        return directionKeyBlocked;
    }

    public void lockDirectionKeys() {
        direction = null;
        directionKeyBlocked = true;

    }

    public boolean isLeave() {
        return leave;
    }

    public enum ControlType {

        MODE_1,
        MODE_2

    }

    public void freeDirectionKey(){
        directionKeyBlocked = false;
    }
}
