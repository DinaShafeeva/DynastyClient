package ru.dynasty.client;

import javafx.stage.Stage;

public class Connector {

    private static ClientSocket clientSocket;
    private static Stage stage;

    public static void connectToServer(String ip, int port) {
        clientSocket = new ClientSocket();
        clientSocket.startConnection(ip, port);
    }

    public static ClientSocket getClientSocket() {
        return clientSocket;
    }

    public static void setClientSocket(ClientSocket clientSocket) {
        Connector.clientSocket = clientSocket;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Connector.stage = stage;
    }
}
