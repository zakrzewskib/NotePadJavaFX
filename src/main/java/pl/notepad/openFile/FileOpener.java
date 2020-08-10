package pl.notepad.openFile;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOpener {

    private File openFile() {
        FileChooser fileChooser = new FileChooser();
        return fileChooser.showOpenDialog(new Stage());
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

}
