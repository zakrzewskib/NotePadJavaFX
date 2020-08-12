package pl.notepad.textArea;

import java.util.ArrayList;
import javafx.scene.control.TextArea;

public class ThisTextArea {
    ArrayList<String> listChangeOfTextArea = new ArrayList<>();

    public ThisTextArea(TextArea textArea) {
        listChangeOfTextArea.add(textArea.getText());
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println(" Text Changed to  " + newValue + "\tfrom  " + oldValue);
                    System.out.print(listChangeOfTextArea.toString() + "-> \t");
                    listChangeOfTextArea.add(textArea.getText());
                    System.out.println(listChangeOfTextArea.toString());

                }
        );
    }

    public ArrayList<String> getListChangeOfTextArea() {
        return listChangeOfTextArea;
    }
}
