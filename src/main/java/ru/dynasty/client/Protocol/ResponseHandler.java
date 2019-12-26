package ru.dynasty.client.Protocol;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ru.dynasty.client.Connector;
import ru.dynasty.client.Controllers.RoomController;
import ru.dynasty.client.Models.Card;
import ru.dynasty.client.Utils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static ru.dynasty.client.Protocol.Commands.*;

public class ResponseHandler {

    public static void doDispatch(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = objectMapper.readValue(message, Response.class);
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getData();
        Commands name = Commands.valueOf(response.getHeader().getName());
        System.out.println(name);
        System.out.println(Commands.LOG_IN.equals(name));
        switch (name) {
            case LOG_IN: {
                System.out.println("riba");
                Platform.setImplicitExit(false);
                Platform.runLater(() -> {
                    System.out.println("riba2");
                    try {
                        Parent root = FXMLLoader.load(ResponseHandler.class.getResource("/Main.fxml"));
                        Connector.setStage(new Stage());
                        Stage stage = Connector.getStage();

                        stage.setScene(new Scene(root));
                        stage.show();
                        Utils.setStage(stage);
                        System.out.println(name + " 2");
                    } catch (IOException e) {
                        System.out.println("riba3");
                        throw new IllegalArgumentException(e);
                    }
                });
                break;
            }
            case UNSUCCESSFUL: {
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("Wrong data!");
                    alert.showAndWait();
                });
                break;
            }
            case REGISTER: {
                Platform.runLater(() -> {
                    try {
                        Parent root = FXMLLoader.load(ResponseHandler.class.getResource("/Main.fxml"));
                        Connector.setStage(new Stage());
                        Stage stage = Connector.getStage();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                });
                break;
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
                break;
            }
            case GET_CARD_LIST: {
                Platform.runLater(() -> {
                    List<Object> cards = (List<Object>) map.get("cards");
                    for (Object cardObject : cards) {
                        LinkedHashMap<String, Object> cardMap = (LinkedHashMap<String, Object>) cardObject;
                        Card card = new Card();
                        Stage stage = Connector.getStage();
                        card.setName((String)cardMap.get("name"));
                        card.setPower((String)cardMap.get("power"));
                        card.setDif((String)cardMap.get("dif"));
                        RoomController.drawCard(card, (HBox) stage.getScene().lookup("#hboxMyCard") );
                    }
                });
            }
            case GET_GAME_INFO: {
                Platform.runLater(() -> {
                    try {
                        Parent root = FXMLLoader.load(ResponseHandler.class.getResource("/Room.fxml"));
                        Stage stage = Connector.getStage();
                        stage.setScene(new Scene(root));
                        ((Label) stage.getScene().lookup("#name")).setText((String) map.get("name"));
                        ((Label) stage.getScene().lookup("#damage")).setText((String) map.get("damage"));
                        String health = (String) map.get("health");
                        String enemyHealth = (String) map.get("enemyHealth");
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                });
                break;
            }

        }
    }

    //динамическое изменение здоровья
    private static void setHealth(String health, ImageView imageview){
        if(Integer.parseInt(health)==0){
            Image img = new Image("src/main/resources/Images/health0.png");
            imageview.setImage(img);
        } else if(Integer.parseInt(health)==1){
            Image img = new Image("src/main/resources/Images/health1.png");
            imageview.setImage(img);
        } else if(Integer.parseInt(health)==2){
            Image img = new Image("src/main/resources/Images/health2.png");
            imageview.setImage(img);
        } else if(Integer.parseInt(health)==3){
            Image img = new Image("src/main/resources/Images/health3.png");
            imageview.setImage(img);
        }
    }

}


