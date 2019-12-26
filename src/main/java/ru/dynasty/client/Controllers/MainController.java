package ru.dynasty.client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.dynasty.client.Utils;

import java.io.IOException;

public class MainController {

    @FXML
    Button play;

    @FXML
    public void onClickProfile() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Profile.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        Utils.setStage(stage);
    }

    @FXML
    public void onClickRools(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Rools.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    @FXML
    public void onClickCards(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AllCards.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    @FXML
    public void onClickPlay(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Room.fxml"));
        Stage stage = (Stage) play.getScene().getWindow();
        stage.getScene().setRoot(root);
        Utils.setStage(stage);
    }

}
