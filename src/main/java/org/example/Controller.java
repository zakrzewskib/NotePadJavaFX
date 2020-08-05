package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class Controller {

    @FXML
    MenuItem newFile;

    @FXML
    Label labelDownside;

    @FXML
    private void initialize() {
        System.out.println("Initialize");
        labelDownside.setText("Test");
    }

    @FXML
    private void fileNewOnAction() {
        System.out.println("New File...");
    }
}
