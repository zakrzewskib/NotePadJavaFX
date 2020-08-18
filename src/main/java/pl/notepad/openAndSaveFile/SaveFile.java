package pl.notepad.openAndSaveFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveFile {
    private static File file;
    public boolean fileWasNull = true;

     public static void setFile(File file) {
        SaveFile.file = file;
    }

    public void saveFileAs(String text) {

        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            fileWasNull = false;
            saveTextToFile(text, file);
        }
    }

    public void saveFile(String text) {
        if (file == null) {
            fileWasNull = true;
            saveFileAs(text);
        } else {
            saveTextToFile(text, file);
        }
    }

    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
