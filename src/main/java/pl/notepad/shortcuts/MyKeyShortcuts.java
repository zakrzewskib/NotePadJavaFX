package pl.notepad.shortcuts;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import pl.notepad.fxmlpackage.Controller;

public class MyKeyShortcuts {

    Controller controller = new Controller();

    public KeyCombination getCtrlPlusN() {
        KeyCombination ctrlPlusN = new KeyCodeCombination(KeyCode.N, KeyCodeCombination.CONTROL_ANY);
        return ctrlPlusN;
    }

    public Runnable getRunnableForCtrlPlusN() {
        Runnable runnableForCtrlPlusN = new Runnable() {
            @Override
            public void run() {
                controller.newFileOnAction();
            }
        };
        return runnableForCtrlPlusN;
    }

    public KeyCombination getCtrlPlusO() {
        KeyCombination ctrlPlusN = new KeyCodeCombination(KeyCode.O, KeyCodeCombination.CONTROL_ANY);
        return ctrlPlusN;
    }

    public Runnable getRunnableForCtrlPlusO() {
        Runnable runnableForCtrlPlusN = new Runnable() {
            @Override
            public void run() {
                controller.openFileOnAction();
            }
        };
        return runnableForCtrlPlusN;
    }
}
