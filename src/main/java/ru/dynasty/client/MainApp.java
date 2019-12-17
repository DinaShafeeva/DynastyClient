package ru.dynasty.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("/Splash.fxml"));
        primaryStage.setTitle("Dynasty");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Utils.setStage(primaryStage);
    }
}
