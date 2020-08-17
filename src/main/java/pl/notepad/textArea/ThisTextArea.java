package pl.notepad.textArea;

import java.util.ArrayList;
import javafx.scene.control.TextArea;
import pl.notepad.fxmlpackage.Controller;

public class ThisTextArea {
    ArrayList<String> listChangeOfTextArea = new ArrayList<>();
    TextArea textArea;
    Controller controller;

    public ThisTextArea(TextArea textArea, Controller controller) {
        this.controller = controller;
        this.textArea = textArea;
        listChangeOfTextArea.add(textArea.getText());
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
                    listChangeOfTextArea.add(textArea.getText());
                    controller.textAreaWasChanged = true;
                }
        );
    }

    public ArrayList<String> getListChangeOfTextArea() {
        return listChangeOfTextArea;
    }
    public void undo(){
        try {
            int last = listChangeOfTextArea.size() - 1;
            listChangeOfTextArea.remove(last);
            textArea.setText(listChangeOfTextArea.get(listChangeOfTextArea.size() - 1));
            listChangeOfTextArea.remove(last);
        } catch (IndexOutOfBoundsException ignored) {
        }
    }
}
