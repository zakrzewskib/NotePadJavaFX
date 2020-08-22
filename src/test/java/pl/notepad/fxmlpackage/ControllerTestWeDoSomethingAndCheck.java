package pl.notepad.fxmlpackage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.notepad.openAndSaveFile.SaveFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControllerTestWeDoSomethingAndCheck {

    Controller controller;
    App app;

    @BeforeAll
    static void setUp() {
        App.main(null);
    }

    @BeforeEach
    void setUp2() {
        app = App.getInstance();
        controller = app.getController();
    }

    @Test
    void textAreaWasChanged_true() {
        assertTrue(controller.textAreaWasChanged);
    }

    @Test
    void textAreaWasChanged_WeDidNotWriteSomething_false() {
        assertFalse(controller.textAreaWasChanged);
    }

    @Test
    void textArea_blank() {
        assertEquals("", controller.textArea.getText());
    }

    @Test
    void saveFileGetFile_notNull() {
        assertNotNull(SaveFile.getFile());
    }

    @Test
    void saveFileGetFile_null() {
        assertNull(SaveFile.getFile());
    }

}