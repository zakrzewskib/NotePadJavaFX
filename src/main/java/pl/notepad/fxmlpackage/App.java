package pl.notepad.fxmlpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import pl.notepad.shortcuts.MyKeyShortcuts;

import java.io.IOException;
import java.util.Timer;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private MyKeyShortcuts keyShortcuts;

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

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    Stage myStage;

    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
        instance = this;

        stage.setTitle("No Title -- NotePad");

        scene = new Scene(loadFXML("notePadLayout"));

        stage.setScene(scene);
        stage.show();

//        controller = fxmlLoader.getController();
        controller = Controller.getInstance();

        keyShortcuts = new MyKeyShortcuts(this);
        addShortCuts();

        stage.setOnCloseRequest(e -> controller.exitOnAction());
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