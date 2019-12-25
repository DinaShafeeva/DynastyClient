package ru.dynasty.client.Protocol;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseHandler {
    public static void doDispatch(String message){
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = objectMapper.readValue(message, Response.class);
        switch (response.getHeader().getName()) {
            case ()
        }

    }
}
