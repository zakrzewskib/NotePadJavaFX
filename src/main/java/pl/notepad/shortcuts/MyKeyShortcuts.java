package pl.notepad.shortcuts;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import pl.notepad.fxmlpackage.App;
import pl.notepad.fxmlpackage.Controller;

import java.io.IOException;

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
        return () -> {
            try {
                controller.newFileOnAction();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public KeyCombination getCtrlPlusO() {
        return new KeyCodeCombination(KeyCode.O, KeyCodeCombination.CONTROL_ANY);
    }

    public Runnable getRunnableForCtrlPlusO() {
        return () -> controller.openFileOnAction();
    }

    public KeyCombination getCtrlPlusS() {
        return new KeyCodeCombination(KeyCode.S, KeyCodeCombination.CONTROL_ANY);
    }

    public Runnable getRunnableForCtrlPlusS() {
        return () -> controller.saveFileOnAction();
    }
}
