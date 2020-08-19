package pl.notepad.shortcuts;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import pl.notepad.fxmlpackage.App;
import pl.notepad.fxmlpackage.Controller;

public class MyKeyShortcuts {
    App app;
    Controller controller;

    public MyKeyShortcuts(App app) {
        this.app = app;
        controller = app.getController();
    }

    public KeyCombination getCtrlPlusN() {
        return new KeyCodeCombination(KeyCode.N, KeyCodeCombination.CONTROL_ANY);
    }

    public Runnable getRunnableForCtrlPlusN() {
        return new Runnable() {
            @Override
            public void run() {
                controller.newFileOnAction();
            }
        };
    }

    public KeyCombination getCtrlPlusO() {
        return new KeyCodeCombination(KeyCode.O, KeyCodeCombination.CONTROL_ANY);
    }

    public Runnable getRunnableForCtrlPlusO() {
        return new Runnable() {
            @Override
            public void run() {
                controller.openFileOnAction();
            }
        };
    }

    public KeyCombination getCtrlPlusS() {
        return new KeyCodeCombination(KeyCode.S, KeyCodeCombination.CONTROL_ANY);
    }

    public Runnable getRunnableForCtrlPlusS() {
        return new Runnable() {
            @Override
            public void run() {
                controller.saveFileOnAction();
            }
        };
    }
}
