package pl.notepad.fxmlpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import pl.notepad.shortcuts.MyKeyShortcuts;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private final MyKeyShortcuts keyShortcuts = new MyKeyShortcuts();

    // Adding keyShortcuts in App (where the scene is) prevents Exceptions
    private void addShortCut(KeyCombination k, Runnable r) {
        scene.getAccelerators().put(k, r);
    }

    private void addShortCuts() {
        addShortCut(keyShortcuts.getCtrlPlusN(), keyShortcuts.getRunnableForCtrlPlusN());
        addShortCut(keyShortcuts.getCtrlPlusO(), keyShortcuts.getRunnableForCtrlPlusO());
        addShortCut(keyShortcuts.getCtrlPlusS(), keyShortcuts.getRunnableForCtrlPlusS());
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("NotePad");

        scene = new Scene(loadFXML("notePadLayout"));

        addShortCuts();

        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}