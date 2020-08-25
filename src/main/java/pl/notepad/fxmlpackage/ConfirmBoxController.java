package pl.notepad.fxmlpackage;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConfirmBoxController {
    @FXML
    Label label;
    @FXML
    Button yesButton;
    @FXML
    Button noButton;
    @FXML
    Button cancelButton;

    boolean answer;
    public boolean somethingWasChosen = false;

    public boolean display(String message, Stage window, Scene scene) {
        window.setScene(scene);
        window.setResizable(false);

        yesButton.setText("Yes");
        noButton.setText("No");
        cancelButton.setText("Cancel");
        label.setText(message);

        yesButton.setOnAction(e -> {
            answer = true;
            somethingWasChosen = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            somethingWasChosen = true;
            window.close();
        });

        cancelButton.setOnAction(e -> {
            somethingWasChosen = false;
            window.close();
        });


        window.showAndWait();
        return answer;
    }
}
