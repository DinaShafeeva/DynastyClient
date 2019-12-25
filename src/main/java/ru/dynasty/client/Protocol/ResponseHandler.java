package ru.dynasty.client.Protocol;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.dynasty.client.Connector;
import ru.dynasty.client.Models.Card;
import sun.jvm.hotspot.tools.ObjectHistogram;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static ru.dynasty.client.Protocol.Commands.*;

public class ResponseHandler {
    public static void doDispatch(String message){
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = objectMapper.readValue(message, Response.class);
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getData();
        Commands name = Commands.valueOf(response.getHeader().getName());
        switch (name) {
            case LOG_IN: {
                Platform.runLater(() -> {
                    try {
                        Parent root = FXMLLoader.load(ResponseHandler.class.getResource("/Main.fxml"));
                        Stage stage = Connector.getStage();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                });
            }
            case REGISTER: {
                Platform.runLater(() -> {
                    try {
                        Parent root = FXMLLoader.load(ResponseHandler.class.getResource("/Main.fxml"));
                        Stage stage = Connector.getStage();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                });
            }
            case PROFILE: {
                Platform.runLater(() -> {
                    try {
                        Parent root = FXMLLoader.load(ResponseHandler.class.getResource("/Profile.fxml"));
                        Stage stage = Connector.getStage();
                        stage.setScene(new Scene(root));
                        ((Label) stage.getScene().lookup("#name")).setText((String) map.get("name"));
                        ((Label) stage.getScene().lookup("#victories")).setText((String) map.get("victories"));
                        ((Label) stage.getScene().lookup("#defeats")).setText((String) map.get("defeats"));
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                });
            }
            case GET_CARD_LIST: {
                Platform.runLater(() -> {
                    List<Object> cards = (List<Object>) map.get("cards");
                    for(Object cardObject: cards) {
                        LinkedHashMap<String, Object> cardMap = (LinkedHashMap<String, Object>)cardObject;
                        Card card = new Card();
                        card.setName((String)cardMap.get("name"));
                        card.setPower((String)cardMap.get("power"));
                        card.setDif((String)cardMap.get("dif"));
                    }
                });
            }
        }
    }
    //здесь я должна динамически рисовать карту, но идет туго
    private static void makeCard(Card card){
        Pane pane = new Pane();
        pane.getChildren().add(ImageView image);
        pane.getChildren().add(Text name);
        pane.getChildren().add(Text power);
        pane.getChildren().add(Text dif);

    }
}
