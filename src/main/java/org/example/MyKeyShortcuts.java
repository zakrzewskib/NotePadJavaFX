package org.example;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class MyKeyShortcuts {

    private final KeyCombination ctrlPlusN = new KeyCodeCombination(KeyCode.N, KeyCodeCombination.CONTROL_ANY);
    Controller controller = new Controller();

    private final Runnable runnableForCtrlPlusN = new Runnable() {
        @Override
        public void run() {
            controller.newFileOnAction();
        }
    };

    public KeyCombination getCtrlPlusN() {
        return ctrlPlusN;
    }

    public Runnable getRunnableForCtrlPlusN() {
        return runnableForCtrlPlusN;
    }
}
