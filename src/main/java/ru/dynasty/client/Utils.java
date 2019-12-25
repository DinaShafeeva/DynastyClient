package ru.dynasty.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Utils {

    private static Stage stage;

    public static void setStage(Stage stage) {
        Utils.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    public static class Resource {

    public static HashMap<String, Scene> scenes = new HashMap<>();

    public static void load() throws IOException {
        Parent rootWelcome = FXMLLoader.load(Utils.class.getResource("/Welcome.fxml"));
        Scene welcome = new Scene(rootWelcome);

        Parent rootSplash = FXMLLoader.load(Utils.class.getResource("/Splash.fxml"));
        Scene splash = new Scene(rootSplash);

        Parent rootLogin = FXMLLoader.load(Utils.class.getResource("/LogIn.fxml"));
        Scene login = new Scene(rootLogin);

        Parent rootRegistration = FXMLLoader.load(Utils.class.getResource("/Registration.fxml"));
        Scene registration = new Scene(rootRegistration);

        Parent rootRoom = FXMLLoader.load(Utils.class.getResource("/Room.fxml"));
        Scene room = new Scene(rootRoom);

        Parent rootMain = FXMLLoader.load(Utils.class.getResource("/Main.fxml"));
        Scene main = new Scene(rootMain);

        scenes.put("welcome", welcome);
        scenes.put("splash", splash);
        scenes.put("login", login);
        scenes.put("registration", registration);
        scenes.put("room", room);
        scenes.put("main", main);
    }
    }
}
