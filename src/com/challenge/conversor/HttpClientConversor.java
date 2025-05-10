package com.challenge.conversor;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;

public class HttpClientConversor {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static String getResponse(String urlExchange) {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(urlExchange))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
