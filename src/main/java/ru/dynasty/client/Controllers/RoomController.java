package ru.dynasty.client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomController {
    @FXML
    ImageView enemyHealth;
    //должна меняться картинка здоровья противника
    @FXML
    ImageView myHealth;
    //должна меняться картинка твоего здоровья
    @FXML
    Text damage;
    //должен заполняться урон
    @FXML
    Text enemy;
    //имя противника нужно получить
    @FXML
    Text name;
    //твоя имя нужно получить
    @FXML
    Button end;
    @FXML
    Button send;
    @FXML
    Button firstCard;

    @FXML
    public void onClickEnd(ActionEvent actionEvent) throws IOException {
        end.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    @FXML
    public void onClickSend(ActionEvent actionEvent) throws IOException {
        //происходит отправка сообщения
    }
    @FXML
    public void onClickCard(ActionEvent actionEvent, Button card, Text name, Text power, Text Dif) throws IOException {
        //при нажатии на карту, имя и сила уходят
    }
}