package pl.notepad.fxmlpackage;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.notepad.shortcuts.MyKeyShortcuts;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private MyKeyShortcuts keyShortcuts;

    // Adding keyShortcuts in App (where the scene is) prevents Exceptions
    private void addShortCut(KeyCombination k, Runnable r) {
        scene.getAccelerators().put(k, r);
    }

    private void addShortCuts() {
        addShortCut(keyShortcuts.getCtrlPlusN(), keyShortcuts.getRunnableForCtrlPlusN());
        addShortCut(keyShortcuts.getCtrlPlusO(), keyShortcuts.getRunnableForCtrlPlusO());
        addShortCut(keyShortcuts.getCtrlPlusS(), keyShortcuts.getRunnableForCtrlPlusS());
    }

    Controller controller;

    public Controller getController() {
        return this.controller;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("NotePad");

        scene = new Scene(loadFXML("notePadLayout"));

        stage.setScene(scene);
        stage.show();

        controller = fxmlLoader.getController();
        // getting JavaFX Controller:
        // https://stackoverflow.com/questions/10751271/accessing-fxml-controller-class

        keyShortcuts = new MyKeyShortcuts(this);
        addShortCuts();

        stage.setOnCloseRequest(
                new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent windowEvent) {
                        controller.exitOnAction();
                    }
                }
        );
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static FXMLLoader fxmlLoader;
    private static Parent loadFXML(String fxml) throws IOException {
        fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}