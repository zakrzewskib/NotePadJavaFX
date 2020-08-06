module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.notepad.fxmlpackage to javafx.fxml; // here
    exports pl.notepad.fxmlpackage;
    /*
     * cannot access class ... because module org.example does not export ... to module javafx.fxml
     *
     * It means that Controllers should be in folder that we are using 'there' (same with App)
     */
}