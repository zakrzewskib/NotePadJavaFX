package pl.notepad.openFile;

import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.example.SaveFileWithFileChooser;

public class FileOpener {

    private static File file;
    private File openFile() {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(new Stage());
        return file;
    }

    private String formatStringFromFile(BufferedReader bufferedReader) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            // delete the last new line separatorJ
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (IOException | NullPointerException ignored) {

        }
        return null;
    }

    public String readStringFromFile() {
        String content = null;
        try {
            FileReader fileReader = new FileReader(openFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            content = formatStringFromFile(bufferedReader);
        } catch (IOException | NullPointerException ignored) {

        }
        return content;
    }
    public void saveFileAs(String text){

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

    public void saveFile(String text){
        if(file == null){
            saveFileAs(text);
        }else {
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
            Logger.getLogger(SaveFileWithFileChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
