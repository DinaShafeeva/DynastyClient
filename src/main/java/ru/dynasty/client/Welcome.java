package ru.dynasty.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Welcome {

    @FXML
    Button login;
    @FXML
    Button registration;

    @FXML
    void clickLoginButton() throws IOException {
        Stage stage = (Stage) login.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        stage.setScene(new Scene(root1));
        stage.show();
    };

    @FXML
    void clickRegistrationButton() throws IOException {
        Stage stage = (Stage) registration.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration.fxml"));
        Parent root1 = (Parent) loader.load();
        stage.setScene(new Scene(root1));
    };
}
