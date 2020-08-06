package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Controller {
    @FXML
    MenuItem newFile;
    @FXML
    MenuItem openFile;
    @FXML
    MenuItem saveFile;
    @FXML
    MenuItem saveFileAs;
    @FXML
    MenuItem exit;
    @FXML
    BorderPane borderPaneNotePad;
    @FXML
    HBox hBoxNotePad;

    NamingMenuItems nm = new NamingMenuItems(this);

    @FXML
    private void initialize() {
        System.out.println("Initialize");
        nm.setNamesForFilesOption();
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("testButton.fxml"));
//            Button button = loader.load();
//            hBoxNotePad.getChildren().add(button);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    public void newFileOnAction() {
        System.out.println("New File...");
    }
}
