package pl.notepad.fxmlpackage;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import pl.notepad.naming.NamingMenuItems;

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
        System.out.println("Initialize " + this.getClass().getName());
        nm.setNamesForFilesOption();
    }

    @FXML
    public void newFileOnAction() {
        System.out.println("New File...");
    }
}
