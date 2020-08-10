package pl.notepad.fxmlpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import pl.notepad.naming.NamingMenuItems;

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

    NamingMenuItems nm = new NamingMenuItems(this);

    @FXML
    private void initialize() {
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
        System.out.println(textArea.getText());
        System.out.println("Save");
    }

    public void editOnAction(ActionEvent actionEvent) {
        System.out.println("edit");
    }
}
