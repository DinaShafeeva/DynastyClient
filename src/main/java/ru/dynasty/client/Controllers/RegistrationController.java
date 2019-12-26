package ru.dynasty.client.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    Text equals;
    @FXML
    Text lengthPassword;

    @FXML
    void clickRegistrateButton() throws IOException {
        if(password1.getText().length() > 6){
            if(password1.getText().equals(password2.getText())) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("login", login.getText());
                map.put("password", password1.getText());
                Connector.getClientSocket().sendJsonMessage(RequestCreator.request(Commands.REGISTER.name(), map));
            } else{
                equals.setText("Passwords are not equals");
            }
        } else {
            lengthPassword.setText("Password should be longer than 6 symbols");
        }
    };
}
