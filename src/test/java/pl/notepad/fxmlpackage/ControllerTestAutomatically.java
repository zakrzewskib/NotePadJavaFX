package pl.notepad.fxmlpackage;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTestAutomatically {

    Controller controller;
    App app;

    @BeforeAll
    static void setUp() {
//        App.main(null);
    }



    @BeforeEach
    void setUp2() {
//        app = App.getInstance();
//        controller = app.getController();
    }

    @Test
    void newFile_textAreaBlank() {
//        controller.newFileOnAction();
//        assertEquals("", controller.textArea.getText());

//        Platform.startup(() ->
//        {
//            Controller controller = App.getInstance().getController();
//            System.out.println(controller.textAreaWasChanged);
//        });
    }

}
