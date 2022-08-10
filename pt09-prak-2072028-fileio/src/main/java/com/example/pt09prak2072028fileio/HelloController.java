package com.example.pt09prak2072028fileio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloController {
    public Button btnSave;
    public Button btnSaveAs;
    public Button btnOpen;
    public TextArea textarea1;

    FileChooser chooser;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void save(File file, String isi) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(isi);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showSaveDialog(new Stage());
    }

    public void saveAsFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showSaveDialog(new Stage());
        if (file != null) {
            save(file, textarea1.getText());
        }
    }

    public void openFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(textarea1.getScene().getWindow());
        if (Files.exists(Paths.get(file.getPath())) && Files.isReadable(Paths.get(file.getPath()))) {
            BufferedReader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(file.getPath()));
                String sTemp;
                String hasil = "";
                while ((sTemp = reader.readLine()) != null) {
                    hasil += sTemp + "\n";
                }
                textarea1.setText(hasil);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}