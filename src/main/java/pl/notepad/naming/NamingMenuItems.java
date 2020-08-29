package pl.notepad.naming;

import javafx.scene.control.MenuItem;
import pl.notepad.fxmlpackage.Controller;

public class NamingMenuItems {

    Controller controller;

    public NamingMenuItems(Controller controller) {
        this.controller = controller;
    }

    private String makeNameWithShortcut(MenuItem menuItem, String shortcut) {
        String before = menuItem.getText();
        StringBuilder after = new StringBuilder();

        after.append(before);
        int howManySpaces = 50 - (before.length() + shortcut.length());

        if(menuItem.equals(controller.saveFile)) {
            howManySpaces += 1;
        } else if(menuItem.equals(controller.saveFileAs)) {
            howManySpaces -= 4;
        }

        after.append(" ".repeat(howManySpaces));
        after.append(shortcut);

        return after.toString();
    }

    public void setNamesForFilesOption() {
        controller.newFile.setText(makeNameWithShortcut(controller.newFile, "Ctrl+N"));
        controller.openFile.setText(makeNameWithShortcut(controller.openFile, "Ctrl+O"));
        controller.saveFile.setText(makeNameWithShortcut(controller.saveFile, "Ctrl+S"));
    }
}
