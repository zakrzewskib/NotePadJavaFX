package org.notepad.shortcuts;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import org.notepad.fxmlpackage.ControllerForFile;

public class MyKeyShortcuts {

    private final KeyCombination ctrlPlusN = new KeyCodeCombination(KeyCode.N, KeyCodeCombination.CONTROL_ANY);
    ControllerForFile controllerForFile = new ControllerForFile();

    private final Runnable runnableForCtrlPlusN = new Runnable() {
        @Override
        public void run() {
            controllerForFile.newFileOnAction();
        }
    };

    public KeyCombination getCtrlPlusN() {
        return ctrlPlusN;
    }

    public Runnable getRunnableForCtrlPlusN() {
        return runnableForCtrlPlusN;
    }
}
