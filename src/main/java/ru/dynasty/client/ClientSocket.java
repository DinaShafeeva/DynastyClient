package ru.dynasty.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.dynasty.client.Protocol.Request;
import ru.dynasty.client.Protocol.ResponseHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private ObjectMapper objectMapper;

    public ClientSocket() {
        objectMapper = new ObjectMapper();
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
                ResponseHandler.doDispatch(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    public void sendJsonMessage(Request request) {
        try {
            writer.println(objectMapper.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
