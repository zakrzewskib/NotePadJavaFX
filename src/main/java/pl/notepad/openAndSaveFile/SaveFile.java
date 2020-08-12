package pl.notepad.openAndSaveFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.SaveFileWithFileChooser;

public class SaveFile {
    private static File file;

    public static File getFile() {
        return file;
    }

    static void setFile(File file) {
        SaveFile.file = file;
    }

    public static void saveFileAs(String text) {

        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            saveTextToFile(text, file);
        }
    }

    public static void saveFile(String text) {
        if (file == null) {
            saveFileAs(text);
        } else {
            saveTextToFile(text, file);
        }
    }

    private static void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveFileWithFileChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
