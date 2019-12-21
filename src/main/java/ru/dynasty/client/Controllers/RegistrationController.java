package ru.dynasty.client.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
            if(password1 == password2) {
                //взять данные с логина и пароля и куда-то их деть при нажатии кнопочки
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
