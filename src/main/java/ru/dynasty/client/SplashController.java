package ru.dynasty.client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class SplashController implements Initializable {

    @FXML
    private ImageView splash;
    @FXML
    private AnchorPane parent;

    @FXML
    public void click() {
        try {
            parent.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/Welcome.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    boolean isTimer = false;

                    @Override
                    public void run() {
                        if (!isTimer) {
                            if (splash.getOpacity() < 0) {
                                isTimer = true;
                                timer.cancel();
                                Utils.getStage().setScene(Utils.Resource.scenes.get("welcome"));
                            }
                            splash.setOpacity(splash.getOpacity() - 0.05);
                        }
                    }
                });
            }
        }, 500, 100);
    }
}
