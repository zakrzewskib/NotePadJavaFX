package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class ControllerForFile {
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

    NamingMenuItems nm = new NamingMenuItems(this);

    @FXML
    private void initialize() {
        System.out.println("Initialize " + this.getClass().getName());
        nm.setNamesForFilesOption();
    }

    @FXML
    public void newFileOnAction() {
        System.out.println("New File...");
    }
}
