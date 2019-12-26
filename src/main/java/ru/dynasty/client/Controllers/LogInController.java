package ru.dynasty.client.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.dynasty.client.ClientSocket;
import ru.dynasty.client.Connector;
import ru.dynasty.client.Protocol.Commands;
import ru.dynasty.client.RequestCreator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogInController {

    @FXML
    Button log;
    @FXML
    TextField login;
    @FXML
    TextField password;

    @FXML
    void clickStartButton() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("login", login.getText());
        map.put("password", password.getText());
        Connector.getClientSocket().sendJsonMessage(RequestCreator.request(Commands.LOG_IN.name(), map));
        log.getScene().getWindow().hide();

    };
}
