package org.example.text;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextEditor extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //initUI(primaryStage);
        menuBar(primaryStage);
    }

    private void initUI(Stage stage) {
        var root = new GridPane();
        root.setVgap(10);
        root.setHgap(5);
        root.setPadding(new Insets(10));

        var label = new Label("Text:");
        var field = new TextField();
        label.setLabelFor(field);
        label.setMnemonicParsing(true);

        root.add(label, 0, 0);
        root.add(field, 2, 0);

        GridPane.setHalignment(label, HPos.RIGHT);

        var scene = new Scene(root);

        menuBar(stage);
        stage.setTitle("Text Editor");
        stage.setScene(scene);
        stage.show();
    }

    private void menuBar(Stage stage) {
        var root = new HBox();
        var menu = new MenuBar();
        menu.prefWidthProperty().bind(stage.widthProperty());

        var handler = new MyMenuHandler();

        var fileMenuItem = new Menu("File");
        menu.getMenus().add(fileMenuItem);

        //Creates a new file for text editing
        var newMenuItem = new Menu("New");
        menu.getMenus().add(newMenuItem);

        //Opens a new File
        var openMenuItem = new Menu("Open");
        openMenuItem.setOnAction(handler);
        fileMenuItem.getItems().add(openMenuItem);

        //saves the contents of the text field to a file
        var saveMenuItem = new Menu("Save");
        saveMenuItem.setOnAction(handler);
        fileMenuItem.getItems().add(saveMenuItem);

        fileMenuItem.getItems().add(new SeparatorMenuItem());

        var exitMenuItem = new Menu("Exit");
        exitMenuItem.setOnAction(event -> Platform.exit());
        fileMenuItem.getItems().add(exitMenuItem);

        root.getChildren().add(menu);
        var scene = new Scene(root, 300, 250);
        stage.setTitle("Text Editor");
        stage.setScene(scene);
        stage.show();
    }

    private static class MyMenuHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            doShowMessageDialog(event);
        }

        private void doShowMessageDialog(ActionEvent event) {
            var menuItem = (MenuItem) event.getSource();
            String item = menuItem.getText();

            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Menu Item Selection Information");
            alert.setContentText(item + " menu item selected");
            alert.showAndWait();
        }
    }
}
