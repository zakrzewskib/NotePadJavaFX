package pl.notepad.textArea;

import java.util.ArrayList;
import javafx.scene.control.TextArea;

public class ThisTextArea {
    ArrayList<String> listChangeOfTextArea = new ArrayList<>();
    public ThisTextArea(TextArea textArea){
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println(" Text Changed to  " + newValue + "\tfrom  " + oldValue);
                    System.out.println(" newValue  " + newValue + "\t last of the list " + oldValue);

            try {
                        if(listChangeOfTextArea.get(listChangeOfTextArea.size() - 1) != newValue) {
                            listChangeOfTextArea.add(textArea.getText());
                        }
                    }catch (IndexOutOfBoundsException e){
                        listChangeOfTextArea.add(textArea.getText());

                    }
                }
        );
    }

    public ArrayList<String> getListChangeOfTextArea() {
        return listChangeOfTextArea;
    }
}
