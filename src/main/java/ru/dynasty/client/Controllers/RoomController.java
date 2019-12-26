package ru.dynasty.client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.dynasty.client.ClientSocket;
import ru.dynasty.client.Models.Card;
import ru.dynasty.client.Models.CardPane;

import java.io.IOException;

public class RoomController {
    @FXML
    Text yourName;
    @FXML
    Button end;
    @FXML
    Button send;
    @FXML
    TextField oneMessage;

    ClientSocket clientSocket;

    @FXML
    HBox hboxMyCard;

    @FXML
    public static void drawCard(Card card, HBox hboxMyCard) {
        CardPane cardPane = new CardPane(card);
        hboxMyCard.getChildren().addAll(cardPane);
    }

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
        String s = oneMessage.getText();
        clientSocket.sendMessage(yourName.getText() + ": " + s);
    }

}
