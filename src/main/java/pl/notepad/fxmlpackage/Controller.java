package pl.notepad.fxmlpackage;

import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import pl.notepad.boxes.ConfirmBox;
import pl.notepad.naming.NamingMenuItems;
import pl.notepad.openAndSaveFile.FileOpener;
import pl.notepad.openAndSaveFile.SaveFile;
import pl.notepad.textArea.ThisTextArea;

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
    @FXML
    CheckMenuItem wordWrapCheck;
    @FXML
    CheckMenuItem statusBarCheck;
    @FXML
    HBox statusBar;

    public boolean textAreaWasChanged = false;

    NamingMenuItems nm = new NamingMenuItems(this);

    SaveFile saveFileClass = new SaveFile();

    private void setNewTextToTextArea(String text) {
        textArea.setText(text);
    }

    private static Controller instance;

    public static Controller getInstance() {
        return instance;
    }

    @FXML
    private void initialize() {
        instance = this;
        nm.setNamesForFilesOption();
        thisTextArea = new ThisTextArea(textArea, this);
    }

    private boolean textAreaIsNullOrBlank() {
        return textArea.getText() == null || textArea.getText().equals("");
    }

    private void displayConfirmBoxToExit() {
        if (!textAreaWasChanged) {
            System.exit(0);
        } else {
            boolean wantToSave = ConfirmBox.display("NotePad", "Do you want to save?");
            if (ConfirmBox.somethingWasChosen) {
                if (wantToSave) {
                    saveFileOnAction();
                }
                System.exit(0);
            }
        }
    }

    private void displayConfirmBoxToNew() {
        if (textAreaIsNullOrBlank() || !textAreaWasChanged) {
            textArea.setText("");
        } else {
            boolean wantToSave = ConfirmBox.display("NotePad", "Do you want to save?");
            if (ConfirmBox.somethingWasChosen) {
                if (wantToSave) {
                    saveFileOnAction();
                }
                SaveFile.setFile(null);
                thisTextArea.resetListChangeOfTextArea();
                wasNewFile = true;
                setNewAppTitle();
                textArea.setText("");
            }
        }
    }

    public boolean wasNewFile = false;

    @FXML
    public void newFileOnAction() {
        displayConfirmBoxToNew();
    }

    public void exitOnAction() {
        displayConfirmBoxToExit();
    }

    public void openFileOnAction() {
        String open = FileOpener.readStringFromFile();
        if(open != null) {
            setNewTextToTextArea(open);
            textAreaWasChanged = false;
            setNewAppTitle();
        }
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
        setNewAppTitle();
    }

    public void setNewAppTitleForNewFile() {
        App.getInstance().myStage.setTitle("No Title -- NotePad");
    }

    public void setNewAppTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        if (textAreaWasChanged) {
            stringBuilder.append("*");
        }
        if (SaveFile.getFile() != null) {
            stringBuilder.append(SaveFile.getFile().getName());
            stringBuilder.append(" -- NotePad");
        } else {
            stringBuilder.append("No Title -- NotePad");
        }
        App.getInstance().myStage.setTitle(stringBuilder.toString());
    }

    @FXML
    public void undoOnAction() {
        System.out.println("undo");
        thisTextArea.undo();
    }

    public void saveFileAsOnAction() {
        System.out.println("saveFileAs");
        saveFileClass.saveFileAs(textArea.getText());
        setNewAppTitle();
    }

    public void wordWrapOnAction() {
        textArea.setWrapText(wordWrapCheck.isSelected());
    }

    public void statusBarOnAction() {
        statusBar.managedProperty().bind(statusBar.visibleProperty());
        statusBar.setVisible(statusBarCheck.isSelected());
    }

    public void aboutOnAction() {
        App.getInstance().getHostServices().showDocument("https://github.com/zakrzewskib/NotePadJavaFX");
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

    public void fontOnAction() {
        System.out.println("font");
    }

    public void zoomInOnAction() {
        System.out.println("zoomIn");
    }

    public void zoomOutOnAction() {
        System.out.println("zoomOut");
    }

}
