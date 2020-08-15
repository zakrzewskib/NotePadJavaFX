package pl.notepad.fxmlpackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DisplayConfirmBoxTestCopyingMethods {

    String textArea;
    public boolean textAreaWasChanged = true;

    @BeforeEach
    void setUp() {

    }

    private boolean textAreaIsNullOrBlank() {
        return textArea == null || textArea.equals("");
    }

    public void saveFileOnAction() {
        textArea = "save";
    }

    private void exitOrNew(String action) {
        if (action.equals("new")) {
            textArea = "";
        } else if (action.equals("exit")){
            textArea = "exit";
        }
    }

    private void displayConfirmBox(String action, boolean wantToSave) {
        if (textAreaIsNullOrBlank() || !textAreaWasChanged) {
            exitOrNew(action);
        } else {
            if (wantToSave) {
                saveFileOnAction();
            } else {
                exitOrNew(action);
            }
        }
    }

    @Test
    public void displayConfirmBox_newAndDoNotWantToSave_blank() {
        // given
        textArea = "abc";

        // when
        displayConfirmBox("new", false);

        // then
        Assertions.assertEquals(textArea, "");
    }

    @Test
    public void displayConfirmBox_newAndWantToSave_save() {
        // given
        textArea = "abc";

        // when
        displayConfirmBox("new", true);

        // then
        Assertions.assertEquals(textArea, "save");
    }

    @Test
    public void displayConfirmBox_exitAndDoNotWantToSave_exit() {
        // given
        textArea = "abc";

        // when
        displayConfirmBox("exit", false);

        // then
        Assertions.assertEquals(textArea, "exit");
    }

    @Test
    public void displayConfirmBox_exitAndWantToSave_save() {
        // given
        textArea = "abc";

        // when
        displayConfirmBox("exit", true);

        // then
        Assertions.assertEquals(textArea, "save");
    }

    @Test
    public void displayConfirmBox_textAreaIsNull_exit() {
        // given
        textArea = null;

        // when
        displayConfirmBox("exit", true);

        // then
        Assertions.assertEquals(textArea, "exit");
    }

    @Test
    public void displayConfirmBox_textAreaIsNull_new() {
        // given
        textArea = null;

        // when
        displayConfirmBox("new", true);

        // then
        Assertions.assertEquals(textArea, "");
    }

    @Test
    public void displayConfirmBox_textAreaIsBlank_new() {
        // given
        textArea = "";

        // when
        displayConfirmBox("new", true);

        // then
        Assertions.assertEquals(textArea, "");
    }

    @Test
    public void displayConfirmBox_textAreaIsBlank_exit() {
        // given
        textArea = "";

        // when
        displayConfirmBox("exit", true);

        // then
        Assertions.assertEquals(textArea, "exit");
    }

    @Test
    public void displayConfirmBox_actionStringIsDifferentAndDoNotSave_textAreaIsTheSame() {
        // given
        textArea = "aba";

        // when
        displayConfirmBox("there is not option to handle this", false);

        assertEquals(textArea, "aba");
    }
}
