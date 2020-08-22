package pl.notepad.fxmlpackage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.notepad.openAndSaveFile.SaveFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

// There are test cases at the bottom of the file.
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
    void textAreaWasChanged() {
        assertTrue(controller.textAreaWasChanged);
    }

    @Test
    void textAreaWasNotChanged() {
        assertFalse(controller.textAreaWasChanged);
    }

    @Test
    void textArea_Blank() {
        assertEquals("", controller.textArea.getText());
    }

    @Test
    void textArea_NotBlank() {
        assertNotEquals("", controller.textArea.getText());
    }

    @Test
    void saveFileGetFile_notNull() {
        assertNotNull(SaveFile.getFile());
    }

    @Test
    void saveFileGetFile_null() {
        assertNull(SaveFile.getFile());
    }

    @Test
    void stageTitle_NoTitle_WithoutAsterisk() {
        assertEquals("No Title -- NotePad", app.myStage.getTitle());
    }

    @Test
    void stageTitle_NoTitle_WithAsterisk() {
        assertEquals("*No Title -- NotePad", app.myStage.getTitle());
    }

    @Test
    void stageTitle_FileName_WithoutAsterisk() {
        assertNotEquals(SaveFile.getFile().getName(), app.myStage.getTitle());
    }

    @Test
    void stageTitle_FileName_WithAsterisk() {
        assertNotEquals("*" + SaveFile.getFile().getName(), app.myStage.getTitle());
    }

}

/*
    In Controller.exitOnAction if you want to run Tests you have to change boolean tests to true

    After launching App, you do what is in given case, and than check if chosen tests pass

    After changing something in the code, you should test case that is related to it

    ?? means there is problem that need to be fixed

    (Yes, it is quite boring. I can't make it automatically, because after closing App I can't make any operations on
    JavaFX Thread)
 */

/*
    Test cases:
    * Write Something -> Exit -> Do not save
    textAreaWasChanged, textArea_NotBlank, saveFileGetFile_null, stageTitle_NoTitle_WithAsterisk

    * Write Something -> Exit -> Save (Choose file)
    textAreaWasNotChanged, textArea_NotBlank, saveFileGetFile_NotNull, stageTitle_FileName_WithoutAsterisk
    stageTitle_FileName_WithAsterisk also passes ???

    * Write Something -> New -> I don't want to save -> exit
    Result: textAreaWasNotChanged, textAreaBlank, saveFileGetFile_null, stageTitle_NoTitle_WithoutAsterisk

    ...
 */