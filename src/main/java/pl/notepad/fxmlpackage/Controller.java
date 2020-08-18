package pl.notepad.fxmlpackage;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import pl.notepad.boxes.ConfirmBox;
import pl.notepad.naming.NamingMenuItems;
import pl.notepad.openAndSaveFile.FileOpener;
import pl.notepad.openAndSaveFile.SaveFile;
import pl.notepad.textArea.ThisTextArea;

import java.util.Timer;

public class Controller {
    ThisTextArea thisTextArea;
    @FXML
    public MenuItem newFile;
    @FXML
    public MenuItem openFile;
    @FXML
    public MenuItem saveFile;
    @FXML
    public MenuItem saveFileAs;
    @FXML
    public MenuItem exit;
    @FXML
    TextArea textArea;

    public boolean textAreaWasChanged = false;

    NamingMenuItems nm = new NamingMenuItems(this);

    SaveFile saveFileClass = new SaveFile();

    private void setNewTextToTextArea(String text) {
        textArea.setText(text);
    }

    @FXML
    private void initialize() {
        nm.setNamesForFilesOption();
        thisTextArea = new ThisTextArea(textArea, this);
    }

    private boolean textAreaIsNullOrBlank() {
        return textArea.getText() == null || textArea.getText().equals("");
    }

    private void exitOrNew(String action) {
        if (action.equals("new")) {
            textArea.setText("");
        } else if (action.equals("exit")){
            System.exit(0);
        }
    }

    private void displayConfirmBox(String action) {
        if (textAreaIsNullOrBlank() || !textAreaWasChanged) {
            exitOrNew(action);
        } else {
            boolean wantToSave = ConfirmBox.display("NotePad", "Do you want to save?");
            if (wantToSave) {
                saveFileOnAction();
            } else {
                exitOrNew(action);
            }
        }
    }

    @FXML
    public void newFileOnAction() {
        displayConfirmBox("new");
    }

    // It handles now two MenuItems
    public void exitOnAction() {
        displayConfirmBox("exit");
    }

    public void openFileOnAction() {
        System.out.println("open");
        setNewTextToTextArea(FileOpener.readStringFromFile());
        textAreaWasChanged = false;
    }

    private void checkIfFileWasNull() {
        if (saveFileClass.fileWasNull) {
            System.out.println("You did not choose file");
        } else {
            textAreaWasChanged = false;
        }
    }

    @FXML
    public void saveFileOnAction() {
        System.out.println(textArea.getText());
        System.out.println("saveFile");
        saveFileClass.saveFile(textArea.getText());
        checkIfFileWasNull();
    }

    @FXML
    public void undoOnAction() {
        System.out.println("undo");
        thisTextArea.undo();
    }

    public void saveFileAsOnAction() {
        System.out.println("saveFileAs");
        saveFileClass.saveFileAs(textArea.getText());
    }

    public void redoOnAction() {
        System.out.println("redo");
    }

    public void cutOnAction() {
        System.out.println("cut");
    }

    public void copyOnAction() {
        System.out.println("copy");
    }

    public void pasteOnAction() {
        System.out.println("paste");
    }

    public void deleteOnAction() {
        System.out.println("delete");
    }

    public void selectAllOnAction() {
        System.out.println("selectAll");
    }

    public void wordWrapOnAction() {
        System.out.println("wordWrap");
    }

    public void fontOnAction() {
        System.out.println("font");
    }

    public void zoomInOnAction() {
        System.out.println("zoomIn");
    }

    public void zoomOutOnAction() {
        System.out.println("zoomOut");
    }

    public void statusBarOnAction() {
        System.out.println("statusBar");
    }

    public void aboutOnAction() {
        System.out.println("about");
    }
}
