package ru.dynasty.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LogIn  {

    @FXML
    Button button;

    @FXML
    void clickStartButton() throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("C:\\DynastyClient\\src\\main\\resources\\Main.fxml"));
        Parent root1 = (Parent) loader.load();
        stage.setScene(new Scene(root1));
        stage.show();
    };
}
