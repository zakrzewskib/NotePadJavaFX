package pl.notepad.fxmlpackage;

import javafx.fxml.FXML;

public abstract class Controller {
    @FXML
    protected void initialize() {
        //System.out.println("Initialize " + this.getClass().getName());
    }
}
