package pl.notepad.textArea;

import javafx.scene.control.TextArea;
import pl.notepad.fxmlpackage.Controller;

import java.util.ArrayList;

public class ThisTextArea {
    ArrayList<String> listOfChangesInTextArea = new ArrayList<>();
    TextArea textArea;
    Controller controller;

    public ThisTextArea(TextArea textArea, Controller controller) {
        this.controller = controller;
        this.textArea = textArea;
        listOfChangesInTextArea.add(textArea.getText());
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
                    listOfChangesInTextArea.add(textArea.getText());
                    deleteFirstSavedChanges(10, 5);

                    if (controller.wasNewFile) {
                        controller.setNewAppTitleForNewFile();
                        controller.textAreaWasChanged = false;
                        controller.wasNewFile = false;
                    } else {
                        controller.textAreaWasChanged = true;
                        controller.setNewAppTitle();
                    }
                }
        );
    }

    public ArrayList<String> getListOfChangesInTextArea() {
        return listOfChangesInTextArea;
    }

    public void deleteFirstSavedChanges(int maxSize, int elements) {
        if (listOfChangesInTextArea.size() > maxSize) {
            if (elements > 0) {
                listOfChangesInTextArea.subList(0, elements).clear();
            }
        }
    }

    public void resetListChangeOfTextArea() {
        listOfChangesInTextArea = new ArrayList<>();
    }

    private ArrayList<String> redoList = new ArrayList<>();

    public void undo() {
        try {
            int last = listOfChangesInTextArea.size() - 1;
            redoList.add(listOfChangesInTextArea.get(last));
            listOfChangesInTextArea.remove(last);
            textArea.setText(listOfChangesInTextArea.get(listOfChangesInTextArea.size() - 1));
            listOfChangesInTextArea.remove(last);

        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void redo() {
        try {
            int last =redoList.size()-1;
            textArea.setText(redoList.get(last));
            redoList.remove(last);
        } catch (IndexOutOfBoundsException ignored) {

        }
    }
}
