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
                    System.out.println(" Text Changed to  " + newValue + "\tfrom  " + oldValue);
                    System.out.print(listChangeOfTextArea.toString() + "-> \t");
                    listChangeOfTextArea.add(textArea.getText());
                    System.out.println(listChangeOfTextArea.toString());

                    // Another reset? - for example:
                    // values are really small - for the test
                    deleteFirstSavedChanges(10, 5);



                    if(controller.wasNewFile) {
                        controller.setNewAppTitleForNewFile();
                        controller.textAreaWasChanged = false;
                        controller.wasNewFile = false;
                    } else {
                        controller.setNewAppTitle();
                        controller.textAreaWasChanged = true;
                    }
                }
        );
    }

    public ArrayList<String> getListChangeOfTextArea() {
        return listChangeOfTextArea;
    }

    public void deleteFirstSavedChanges(int maxSize, int elements) {
        if(listChangeOfTextArea.size() > maxSize) {
            if (elements > 0) {
                listChangeOfTextArea.subList(0, elements).clear();
            }
        }
    }

    public void resetListChangeOfTextArea() {
        listChangeOfTextArea = new ArrayList<>();
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
