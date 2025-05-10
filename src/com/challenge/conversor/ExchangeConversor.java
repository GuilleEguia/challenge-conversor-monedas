package com.challenge.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExchangeConversor {
    private static final String API_KEY = "yourApiKey";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";


    public static String urlExchange(String baseTargetCurrency, String mount) {
        try {
            String uri = String.format("%s%s/pair/%s/%s", BASE_URL, API_KEY, baseTargetCurrency, mount);
            String response = HttpClientConversor.getResponse(uri);
            JsonObject json = JsonParser.parseString(response).getAsJsonObject();
            return json.get("conversion_result").getAsString();
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return null;
        }
    }
}
