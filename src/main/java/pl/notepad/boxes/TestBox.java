package pl.notepad.boxes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.notepad.fxmlpackage.App;
import pl.notepad.fxmlpackage.TController;

import java.io.IOException;

public class TestBox {

    public Stage window;
    public Scene scene;
    boolean answer;
    public boolean somethingWasChosen;

    public boolean display(String title, String message) throws IOException {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        scene = new Scene(loadFXML("confirmBox"));

        TController t = fxmlLoader.getController();
        answer = t.display(message, window, scene);
        somethingWasChosen = t.somethingWasChosen;
        System.out.println("somethingWasChosen (in TestBox) is: " + somethingWasChosen);
        return answer;
    }

    FXMLLoader fxmlLoader;

    private Parent loadFXML(String fxml) throws IOException {
        fxmlLoader = new FXMLLoader(TestBox.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
