package pl.notepad.shortcuts;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import pl.notepad.fxmlpackage.Controller;

public class MyKeyShortcuts {

    Controller controller = new Controller();

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

    // getting textArea is complicated 'because Threads'
    // https://stackoverflow.com/questions/31408363/javafx-changelistener-not-always-working/31414801#31414801
    public Runnable getRunnableForCtrlPlusS() {
        return new Runnable() {
            @Override
            public void run() {
                //controller.saveFileOnAction(); // does not work
                //Platform.runLater(() -> controller.saveFileOnAction()); // does not work
                System.out.println("should be saving");
            }
        };
    }
}
