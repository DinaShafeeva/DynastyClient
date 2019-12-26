package ru.dynasty.client.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.dynasty.client.Utils;

import java.io.IOException;

public class WelcomeController {

    @FXML
    Button login;
    @FXML
    Button registration;

    @FXML
    void clickLoginButton() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/LogIn.fxml"));
            Stage stage = (Stage) login.getScene().getWindow();
            stage.getScene().setRoot(root);
            Utils.setStage(stage);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @FXML
    void clickRegistrationButton() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Registration.fxml"));
            Stage stage = (Stage) registration.getScene().getWindow();
            stage.getScene().setRoot(root);
            Utils.setStage(stage);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
