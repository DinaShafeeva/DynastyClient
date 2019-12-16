package ru.dynasty.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/Splash.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("Dynasty");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Utils.setStage(primaryStage);
    }
}
