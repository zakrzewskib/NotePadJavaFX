package org.example;

import javafx.scene.control.MenuItem;

public class NamingMenuItems {

    ControllerForFile controllerForFile;

    public NamingMenuItems(ControllerForFile controllerForFile) {
        this.controllerForFile = controllerForFile;
    }

    private String makeNameWithShortcut(MenuItem menuItem, String shortcut) {
        String before = menuItem.getText();
        StringBuilder after = new StringBuilder();

        after.append(before);
        int howManySpaces = 50 - (before.length() + shortcut.length());

        if(menuItem.equals(controllerForFile.saveFile)) {
            howManySpaces += 1;
        } else if(menuItem.equals(controllerForFile.saveFileAs)) {
            howManySpaces -= 4;
        }

        after.append(" ".repeat(howManySpaces));
        after.append(shortcut);

        return after.toString();
    }

    public void setNamesForFilesOption() {
        controllerForFile.newFile.setText(makeNameWithShortcut(controllerForFile.newFile, "Ctrl+N"));
        controllerForFile.openFile.setText(makeNameWithShortcut(controllerForFile.openFile, "Ctrl+O"));
        controllerForFile.saveFile.setText(makeNameWithShortcut(controllerForFile.saveFile, "Ctrl+S"));
        controllerForFile.saveFileAs.setText(makeNameWithShortcut(controllerForFile.saveFileAs, "Ctrl+Shift+S"));
        controllerForFile.openFile.setText(makeNameWithShortcut(controllerForFile.openFile, ""));
    }
}
