package org.notepad.fxmlpackage;

import javafx.fxml.FXML;

public class ControllerForEdit {

    @FXML
    private void initialize() {
        System.out.println("Initialize " + this.getClass().getName());
    }

    public void editOnAction() {
        System.out.println("Edit");
    }
}
