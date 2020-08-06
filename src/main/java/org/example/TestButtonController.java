package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TestButtonController {
    @FXML
    Button buttonn;

    public void buttonnOnAction() {
        System.out.println("Guzik");
    }
}
