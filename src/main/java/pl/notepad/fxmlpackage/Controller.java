package pl.notepad.fxmlpackage;

import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
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

    public boolean textAreaWasChanged = false;

    NamingMenuItems nm = new NamingMenuItems(this);

    Timer timer = new Timer();
    SaveFile saveFileClass = new SaveFile();

    private void setNewTextToTextArea(String text) {
        textArea.setText(text);
    }

    @FXML
    private void initialize() {
        nm.setNamesForFilesOption();
        thisTextArea = new ThisTextArea(textArea, this);

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("textAreaWasChanged= " + textAreaWasChanged);
//            }
//        }, 0, 1000);
    }

    @FXML
    public void newFileOnAction() {
        if (textAreaWasChanged) {
            System.out.println(textArea.getText());
            if(textArea.getText() == null || textArea.getText().equals("")) {
                textArea.setText("");
                System.out.println("New file");
            } else {
                System.out.println("We wont let you make new File");
            }
        } else {
            textArea.setText("");
            System.out.println("New file");
        }
    }

    public void openFileOnAction() {
        System.out.println("open");
        setNewTextToTextArea(FileOpener.readStringFromFile());
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

    public void exitOnAction() {
        System.out.println("exit and Save");
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
