package pl.notepad.textArea;

import java.util.ArrayList;
import javafx.scene.control.TextArea;

public class ThisTextArea {
    ArrayList<String> listChangeOfTextArea = new ArrayList<>();
    TextArea textArea;
    public ThisTextArea(TextArea textArea) {
        this.textArea = textArea;
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
