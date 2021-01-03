package org.example.text.texteditor;

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
        String osName = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");
        String javaFxVersion = System.getProperty("javafx.version");
        label.setText(String.format("Hello, JavaFX %s%n, running on %s%n with Java %s.%n",javaFxVersion, osName, javaVersion));
    }
}
