package org.example.text;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.constants.AppConstants;

import java.io.File;
import java.util.List;

public class TextEditor extends Application {
    private static final String MISC_DIR = "src/main/resources/misc";
    private static MyMenuHandler handler = new MyMenuHandler();
    private static final List<FileChooser.ExtensionFilter> FILE_EXT_LIST = List.of(
            new FileChooser.ExtensionFilter("All", "*"),
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("HTML Files", "*.html"),
            new FileChooser.ExtensionFilter("XML Files", "*.xml"),
            new FileChooser.ExtensionFilter("FXML Files", "*.fxml"),
            new FileChooser.ExtensionFilter("Java Files", "*.java")
    );

    private GridPane rootPane;
    private static TextArea textArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            initUI(primaryStage);
        } catch (Exception e) {
            AppConstants.printError(e);
            throw e;
        }
    }

    private void initUI(Stage stage) {
        var menu = menuBar(stage);
        rootPane = gridLayout(menu, textArea);
        var scene = new Scene(rootPane, 280, 300);

        stage.setTitle("Text Editor");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane gridLayout(Node... nodes) {
        var pane = new GridPane();
        pane.setHgap(8);
        pane.setVgap(8);
        pane.setPadding(new Insets(5));

        var cons1 = new ColumnConstraints();
        cons1.setHgrow(Priority.NEVER);

        var cons2 = new ColumnConstraints();
        cons2.setHgrow(Priority.ALWAYS);
        pane.getColumnConstraints().addAll(cons1, cons2);

        var row1 = new RowConstraints();
        row1.setVgrow(Priority.NEVER);

        var row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);
        pane.getRowConstraints().addAll(row1, row2);

        pane.add(nodes[0], 0, 0);
        pane.add(nodes[1], 0, 1, 4, 2);
        return pane;
    }

    private MenuBar menuBar(Stage stage) {
        var menu = new MenuBar();
        menu.prefWidthProperty().bind(stage.widthProperty());

        var fileMenuItem = new Menu("File");
        menu.getMenus().add(fileMenuItem);

        //Creates a new file for text editing
        //i.e., activates the text-field for text editing.
        var newMenuItem = new Menu("New");
        fileMenuItem.getItems().add(newMenuItem);

        var openMenuItem = openFile(stage);
        fileMenuItem.getItems().add(openMenuItem);

        var saveMenuItem = saveFile(stage);
        fileMenuItem.getItems().add(saveMenuItem);

        fileMenuItem.getItems().add(new SeparatorMenuItem());

        var exitMenuItem = new Menu("Exit");
        exitMenuItem.setOnAction(event -> Platform.exit());
        fileMenuItem.getItems().add(exitMenuItem);
        return menu;
    }

    //TODO: Opens a textual file and populates the text box with its contents.
    private Menu openFile(Stage stage) {
        var fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(MISC_DIR));
        fileChooser.getExtensionFilters().addAll(FILE_EXT_LIST);

        var menu = new Menu("Open");
        menu.setOnAction(event -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            System.out.println("Opened: " + selectedFile.getAbsolutePath());
            readFileContent(selectedFile);
        });
        return menu;
    }

    //TODO: Saves the contents of the textbox to a textual file
    private Menu saveFile(Stage stage) {
        var fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(MISC_DIR));
        fileChooser.setInitialFileName("file.txt");

        var menu = new Menu("Save");
        menu.setOnAction(event -> {
            File savedFile = fileChooser.showSaveDialog(stage);

            //saves the contents of the text field to a file
            System.out.println("Saved: " + savedFile.getAbsolutePath());
            handler.doShowMessageDialog(event);
        });
        return menu;
    }

    private void readFileContent(File input) {
        textArea.setText(input.getName());
        textArea.setWrapText(true);
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
