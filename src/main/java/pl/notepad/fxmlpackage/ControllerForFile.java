package pl.notepad.fxmlpackage;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import pl.notepad.naming.NamingMenuItems;

import java.util.Timer;
import java.util.TimerTask;

public class ControllerForFile {
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

    NamingMenuItems nm = new NamingMenuItems(this);


    @FXML
    private void initialize() {
        //System.out.println("Initialize " + this.getClass().getName());
        nm.setNamesForFilesOption();
    }

    @FXML
    public void newFileOnAction() {
        System.out.println("New File...");
    }

    @FXML
    TextArea textArea;

    @FXML
    public void saveFileOnAction() {
        //System.out.println(textArea.getText());
    }
}
