package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.applicationinsights.core.dependencies.google.gson.Gson;
import model.Events;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static final String SEPARATEUR = "-";
    public static final String URL_API = "http://localhost:8080/decrypt";

    private Utils() {
    }

    public static String print(List<Events> logs) {
        StringBuilder result = new StringBuilder();
        for (Events log : logs) {
            if (result.length() == 0) {
                result.append(log.getId());
            } else {
                result.append(SEPARATEUR);
                result.append(log.getId());
            }
        }
        return result.toString();
    }

    public static String eventsToJson(List<Events> events) {
        return new Gson().toJson(events);
    }

    public static String sendRequestToApi(String message, String mode) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String responseString = "";
        try {
            HttpGet httpGet = new HttpGet(URL_API);
            URI uri = new URIBuilder(httpGet.getURI())
                    .addParameter("mode", mode)
                    .addParameter("message", message)
                    .build();
            (httpGet).setURI(uri);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            responseString = new BasicResponseHandler().handleResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }

        return responseString;
    }

    public static List<Events> jsonToEvents(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(response, Events[].class));
    }
}
