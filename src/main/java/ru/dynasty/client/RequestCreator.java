package ru.dynasty.client;

import ru.dynasty.client.Protocol.Request;

import java.util.Map;

public class RequestCreator {
    public static Request request (String header, Map<String, Object> parameters) {
        Request request = new Request();
        request.setHeader(header);
        request.setPayloadFromMap(parameters);
        return request;
    }
}
