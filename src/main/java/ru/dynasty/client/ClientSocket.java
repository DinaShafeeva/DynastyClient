package ru.dynasty.client;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;

    String name;

    public ClientSocket(String name, TextArea textArea) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameMess){
        name = nameMess;
    }

    public void startConnection(String ip, Integer port) {
        try{
            this.clientSocket = new Socket(ip, port);
            this.writer = new PrintWriter(clientSocket.getOutputStream(), true);
            this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            new Thread(receiveMessage).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }

    private Runnable receiveMessage = () -> {
        while (true) {
            try {
                String message = reader.readLine();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
