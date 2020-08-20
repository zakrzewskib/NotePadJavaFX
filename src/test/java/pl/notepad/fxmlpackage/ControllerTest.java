package pl.notepad.fxmlpackage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControllerTest {

    Controller controller;
    App app;

    @BeforeAll
    static void setUp() {
        App.main(null);
        /*
        If you do nothing it wont affect tests
         */
    }

    @BeforeEach
    void setUp2() {
        app = App.getInstance();
        controller = app.getController();
    }

    @Test
    void textAreaWasChanged() {
        controller.textArea.setText("something");
        assertTrue(controller.textAreaWasChanged);
    }

    @Test
    void textAreaWasNotChanged() {
        assertFalse(controller.textAreaWasChanged);
    }

    // Exception
//    @Test
//    void open() {
//        controller.openFileOnAction();
//    }

}