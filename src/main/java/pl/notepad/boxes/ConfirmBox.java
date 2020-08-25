package pl.notepad.boxes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.notepad.fxmlpackage.ConfirmBoxController;

import java.io.IOException;

public class ConfirmBox {

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

        ConfirmBoxController t = fxmlLoader.getController();
        answer = t.display(message, window, scene);
        somethingWasChosen = t.somethingWasChosen;
        System.out.println(somethingWasChosen);
        return answer;
    }

    FXMLLoader fxmlLoader;

    private Parent loadFXML(String fxml) throws IOException {
        fxmlLoader = new FXMLLoader(ConfirmBox.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
