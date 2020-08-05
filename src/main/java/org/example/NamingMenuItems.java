package org.example;

import javafx.scene.control.MenuItem;

public class NamingMenuItems {

    Controller controller;

    public NamingMenuItems(Controller controller) {
        this.controller = controller;
    }

    private String makeNameWithShortcut(MenuItem menuItem, String shortcut) {
        String before = menuItem.getText();
        StringBuilder after = new StringBuilder();

        after.append(before);
        int howManySpaces = 40 - (before.length() + shortcut.length());

        // Trochę jednak to słabe jest bo ogarnąłem że 40 znaków to nie zawsze ta sama szerokość
        // np. ... są "krótsze" niż mmm XD
        after.append(" ".repeat(howManySpaces));
        after.append(shortcut);

        System.out.println(after.toString().length());

        return after.toString();
    }

    public void setNamesForFilesOption() {
        controller.newFile.setText(makeNameWithShortcut(controller.newFile, "Ctrl+N"));
        controller.openFile.setText(makeNameWithShortcut(controller.openFile, "Ctrl+O"));
        controller.saveFile.setText(makeNameWithShortcut(controller.saveFile, "Ctrl+S"));
        controller.saveFileAs.setText(makeNameWithShortcut(controller.saveFileAs, "Ctrl+Shift+S"));
        controller.openFile.setText(makeNameWithShortcut(controller.openFile, ""));
    }
}
