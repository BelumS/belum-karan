package org.example.text;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TextEditorController implements Initializable {

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String javaVersion = System.getProperty("java.version");
        String javaFxVersion = System.getProperty("javafx.version");
        label.setText("Hello, JavaFX " + javaFxVersion + "\n Running on Java " + javaVersion + ".");
    }
}
