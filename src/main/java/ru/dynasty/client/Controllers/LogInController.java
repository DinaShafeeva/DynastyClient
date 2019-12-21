package ru.dynasty.client.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    @FXML
    Button log;
    @FXML
    TextField login;
    @FXML
    TextField password;

    @FXML
    void clickStartButton() throws IOException {
            login.getText();
            password.getText();
        //проверяем равенство пароля и логина в бд и тогда нажимается кнопочка
        try {
            log.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    };
}
