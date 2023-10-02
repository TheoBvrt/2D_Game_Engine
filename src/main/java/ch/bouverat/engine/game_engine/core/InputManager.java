package ch.bouverat.engine.game_engine.core;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class InputManager {

    private static boolean[] key = new boolean[KeyCode.values().length];
    private static boolean[] keyDown = new boolean[KeyCode.values().length];
    private final Scene scene;
    public InputManager (Scene scene) {
        this.scene = scene;
        keyReader();
    }

    private void keyReader() {
        scene.setOnKeyPressed(event -> {
            key[event.getCode().ordinal()] = true;
            if (!keyDown[event.getCode().ordinal()]) {
                keyDown[event.getCode().ordinal()] = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            key[event.getCode().ordinal()] = false;
            keyDown[event.getCode().ordinal()] = false;
        });
    }

    public static boolean keyPressed(KeyCode code) {
        return key[code.ordinal()];
    }

    public static boolean keyIsDown(KeyCode code) {
        int index = code.ordinal();
        if (keyDown[index]) {
            keyDown[index] = false;
            return true;
        }
        return false;
    }
}
