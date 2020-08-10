package pl.notepad.fxmlpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import pl.notepad.naming.NamingMenuItems;
import pl.notepad.openFile.FileOpener;
import pl.notepad.openFile.SaveFile;

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

    NamingMenuItems nm = new NamingMenuItems(this);

    private void setNewTextToTextArea(String text) {
        textArea.setText(text);
    }

    @FXML
    private void initialize() {
        nm.setNamesForFilesOption();
    }

    @FXML
    public void newFileOnAction() {
        System.out.println("newFile");
    }

    public void openFileOnAction() {
        System.out.println("open");
        FileOpener fileOpener = new FileOpener();
        setNewTextToTextArea(fileOpener.readStringFromFile());
    }
    
    @FXML
    public void saveFileOnAction() {
        System.out.println(textArea.getText());
        System.out.println("saveFile");
        SaveFile.saveFile(textArea.getText());
    }

    @FXML
    public void undoOnAction() {
        System.out.println("undo");
    }

    public void saveFileAsOnAction(ActionEvent actionEvent) {
        System.out.println("saveFileAs");
        SaveFile.saveFileAs(textArea.getText());
    }

    public void exitOnAction(ActionEvent actionEvent) {
        System.out.println("exit and Save");
    }

    public void redoOnAction(ActionEvent actionEvent) {
        System.out.println("redo");
    }

    public void cutOnAction(ActionEvent actionEvent) {
        System.out.println("cut");
    }

    public void copyOnAction(ActionEvent actionEvent) {
        System.out.println("copy");
    }

    public void pasteOnAction(ActionEvent actionEvent) {
        System.out.println("paste");
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        System.out.println("delete");
    }

    public void selectAllOnAction(ActionEvent actionEvent) {
        System.out.println("selectAll");
    }

    public void wordWrapOnAction(ActionEvent actionEvent) {
        System.out.println("wordWrap");
    }

    public void fontOnAction(ActionEvent actionEvent) {
        System.out.println("font");
    }

    public void zoomInOnAction(ActionEvent actionEvent) {
        System.out.println("zoomIn");
    }

    public void zoomOutOnAction(ActionEvent actionEvent) {
        System.out.println("zoomOut");
    }

    public void statusBarOnAction(ActionEvent actionEvent) {
        System.out.println("statusBar");
    }

    public void aboutOnAction(ActionEvent actionEvent) {
        System.out.println("about");
    }
}
