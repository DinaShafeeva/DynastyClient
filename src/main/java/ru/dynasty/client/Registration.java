package ru.dynasty.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Registration {
    @FXML
    Button button;

    @FXML
    void clickRegistrateButton() throws IOException {
        try {
            button.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    };
}
