package ru.dynasty.client.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.dynasty.client.Connector;
import ru.dynasty.client.Protocol.Commands;
import ru.dynasty.client.RequestCreator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistrationController {
    @FXML
    Button regist;
    @FXML
    TextField login;
    @FXML
    TextField password1;
    @FXML
    TextField password2;

    @FXML
    void clickRegistrateButton() throws IOException {
        if(password1.getLength() > 6){
            if(password1.getText().equals(password2.getText())) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("login", login.getText());
                map.put("password", password1.getText());
                Connector.getClientSocket().sendJsonMessage(RequestCreator.request(Commands.REGISTER.name(), map));
                try {
                    regist.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }
            } else{
                //пароли не равны
            }
        } else {
            //просит заново ввести пароль
        }
    };
}
