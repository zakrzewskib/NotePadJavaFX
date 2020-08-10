//package org.example;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//public class FileChooserSample extends Application {
//
////    private final Desktop desktop = Desktop.getDesktop();
//    private Stage desktop;
//
//    @Override
//    public void start(final Stage stage) {
//        desktop = stage;
//        stage.setTitle("File Chooser Sample");
//
//        final FileChooser fileChooser = new FileChooser();
//
//        final Button openButton = new Button("Open a Picture...");
//        final Button openMultipleButton = new Button("Open Pictures...");
//
//        openButton.setOnAction(
//                e -> {
//                    configureFileChooser(fileChooser);
//                    File file = fileChooser.showOpenDialog(stage);
//                    if (file != null) {
//                        openFile(file);
//                    }
//                });
//
//        openMultipleButton.setOnAction(
//                e -> {
//                    configureFileChooser(fileChooser);
//                    List<File> list =
//                            fileChooser.showOpenMultipleDialog(stage);
//                    if (list != null) {
//                        for (File file : list) {
//                            openFile(file);
//                        }
//                    }
//                });
//
//        final GridPane inputGridPane = new GridPane();
//
//        GridPane.setConstraints(openButton, 0, 0);
//        GridPane.setConstraints(openMultipleButton, 1, 0);
//        inputGridPane.setHgap(6);
//        inputGridPane.setVgap(6);
//        inputGridPane.getChildren().addAll(openButton, openMultipleButton);
//
//        final Pane rootGroup = new VBox(12);
//        rootGroup.getChildren().addAll(inputGridPane);
//        rootGroup.setPadding(new Insets(12, 12, 12, 12));
//
//        stage.setScene(new Scene(rootGroup));
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//
//    private static void configureFileChooser(final FileChooser fileChooser) {
//        fileChooser.setTitle("View Pictures");
//        fileChooser.setInitialDirectory(
//                new File(System.getProperty("user.home"))
//        );
//    }
//
//
//    private void openFile(File file) {
//        System.out.println("file exist:  " +file.getName());
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Save Image");
//        if (file != null) {
//            try {
//                ImageIO.write(SwingFXUtils.fromFXImage(pic.getImage(),
//                        null), "png", file);
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//
////        try {
////            desktop.open(file);
////        } catch (IOException ex) {
////            Logger.getLogger(
////                    FileChooserSample.class.getName()).log(
////                    Level.SEVERE, null, ex
////            );
////        }
//    }
//}
