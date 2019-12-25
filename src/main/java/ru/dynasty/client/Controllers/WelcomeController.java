package ru.dynasty.client.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    Button login;
    @FXML
    Button registration;

    @FXML
    void clickLoginButton() throws IOException {
        try {
            login.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/LogIn.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    };

    @FXML
    void clickRegistrationButton() throws IOException {
        try {
            registration.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/Registration.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    };
}
