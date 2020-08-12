package pl.notepad.openAndSaveFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileOpener {

    private static File openFile() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        SaveFile saveFile = new SaveFile();
        saveFile.setFile(file);
        return file;
    }

    private static String formatStringFromFile(BufferedReader bufferedReader) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
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

    public static String readStringFromFile() {
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
