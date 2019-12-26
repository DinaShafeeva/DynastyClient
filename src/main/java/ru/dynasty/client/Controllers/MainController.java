package ru.dynasty.client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.dynasty.client.Connector;
import ru.dynasty.client.Protocol.Commands;
import ru.dynasty.client.RequestCreator;
import ru.dynasty.client.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "start game");
        Connector.getClientSocket().sendJsonMessage(RequestCreator.request(Commands.START_GAME.name(), map));
        Stage stage = (Stage) play.getScene().getWindow();
        stage.getScene().setRoot(root);
        Utils.setStage(stage);
    }

}
