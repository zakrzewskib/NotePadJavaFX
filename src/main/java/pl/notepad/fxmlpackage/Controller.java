package pl.notepad.fxmlpackage;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import pl.notepad.naming.NamingMenuItems;
import pl.notepad.openAndSaveFile.FileOpener;
import pl.notepad.openAndSaveFile.SaveFile;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {
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

    String previousTextArea;
    boolean textAreaWasChanged = false;

    NamingMenuItems nm = new NamingMenuItems(this);

    Timer timer = new Timer();

    private void setNewTextToTextArea(String text) {
        textArea.setText(text);
    }

    @FXML
    private void initialize() {
        nm.setNamesForFilesOption();
        previousTextArea = textArea.getText();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!previousTextArea.equals(textArea.getText())) {
                    //System.out.println("Change");
                    textAreaWasChanged = true;
                }
            }
        }, 0, 1000);
    }

    @FXML
    public void newFileOnAction() {
        if(textAreaWasChanged) {
            // should open up a window
            System.out.println("We wont let you make new File");
        } else {
            textArea.setText("");
        }

        System.out.println("newFile");
    }

    public void openFileOnAction() {
        System.out.println("open");
        setNewTextToTextArea(FileOpener.readStringFromFile());
    }
    
    @FXML
    public void saveFileOnAction() {
        System.out.println(textArea.getText());
        System.out.println("saveFile");
        SaveFile.saveFile(textArea.getText());
        previousTextArea = textArea.getText();
        textAreaWasChanged = false;
    }

    @FXML
    public void undoOnAction() {
        System.out.println("undo");
    }

    public void saveFileAsOnAction() {
        System.out.println("saveFileAs");
        SaveFile.saveFileAs(textArea.getText());
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
