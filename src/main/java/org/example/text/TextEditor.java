package org.example.text;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.constants.AppConstants;
import org.example.utils.FileUtils;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import static org.example.utils.FileUtils.MISC_DIR;

public class TextEditor extends Application {
    private static final MyMenuHandler MENU_HANDLER = new MyMenuHandler();
    private static final List<FileChooser.ExtensionFilter> FILE_EXT_LIST = List.of(
            new FileChooser.ExtensionFilter("All", "*"),
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("HTML Files", "*.html"),
            new FileChooser.ExtensionFilter("XML Files", "*.xml"),
            new FileChooser.ExtensionFilter("FXML Files", "*.fxml"),
            new FileChooser.ExtensionFilter("Java Files", "*.java")
    );

    private GridPane rootPane;

    private static final TextArea TEXT_AREA = new TextArea();

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
        rootPane = gridLayout(menu, TEXT_AREA);
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

        var fileMenu = new Menu("_File");
        menu.getMenus().add(fileMenu);

        var newMenuItem = createNewTab(stage);
        var openMenuItem = openFile(stage);
        var saveMenuItem = saveFile(stage);
        var exitMenuItem = exitItem();
        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, exitMenuItem);

        return menu;
    }

    private MenuItem openFile(Stage stage) {
        var menu = new MenuItem("Open");
        menu.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));

        var fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(MISC_DIR));
        fileChooser.getExtensionFilters().addAll(FILE_EXT_LIST);

        menu.setOnAction(event -> {
            File selectedFile = fileChooser.showOpenDialog(stage);

            if (selectedFile != null) {
                readFileContent(Path.of(selectedFile.getAbsolutePath()));
            } else {
                System.out.println("Open File Operation was cancelled.");
            }
        });
        return menu;
    }

    //TODO: "New" should create a new tab/window in the pane, and not a new file.
    private MenuItem createNewTab(Stage stage) {
        var menu = new MenuItem("New");
        menu.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        menu.setOnAction(event -> TEXT_AREA.clear());
        return menu;
    }

    private MenuItem saveFile(Stage stage) {
        var menu = new MenuItem("Save");
        menu.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));

        var fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(MISC_DIR));
        fileChooser.setInitialFileName("file.txt");

        menu.setOnAction(event -> {
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                writeFileContent(file);
                MENU_HANDLER.doShowSaveDialog(file.getName());
            } else {
                System.out.println("Save File Operation was cancelled.");
            }
        });
        return menu;
    }

    private MenuItem exitItem() {
        var menu = new MenuItem("Exit");
        menu.setAccelerator(KeyCombination.keyCombination("Esc"));
        menu.setOnAction(event -> Platform.exit());
        return menu;
    }

    private void readFileContent(Path path) {
        System.out.println("Opened: " + path.getFileName());
        TEXT_AREA.setText(FileUtils.readFileFrom(path));
        TEXT_AREA.setWrapText(true);
    }

    private void writeFileContent(File file) {
        final String content = TEXT_AREA.getText();
        TEXT_AREA.commitValue();
        TEXT_AREA.cancelEdit();
        FileUtils.lockAndSave(file, content);
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

        private void doShowSaveDialog(String fileName) {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Save Dialog");
            alert.setHeaderText("Menu Item Saved Information");
            alert.setContentText("'" + fileName + "' was successfully saved!");
            alert.showAndWait();
        }
    }
}
