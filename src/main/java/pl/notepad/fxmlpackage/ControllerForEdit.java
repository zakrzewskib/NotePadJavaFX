package pl.notepad.fxmlpackage;

import javafx.fxml.FXML;

public class ControllerForEdit {

    ControllerForFile c = new ControllerForFile();

    @FXML
    private void initialize() {
        //System.out.println("Initialize " + this.getClass().getName());
    }

    public void editOnAction() {
        System.out.println("Edit");
        System.out.println(c.newFile.getText());
    }
}
