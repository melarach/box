package boxapp.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.microsoft.applicationinsights.core.dependencies.google.gson.Gson;

import boxapp.model.Events;

public class Utils {
	public static final String SEPARATEUR = "-";
	public static final String URL_API = "http://localhost:8080/decrypt";

	private Utils() {
	}

	public static String print(List<Events> logs) {
		StringBuilder result = new StringBuilder();
		if (Optional.ofNullable(logs).filter(list->!list.isEmpty()).isPresent()) {
			result.append(logs.get(0).getId());
			IntStream.range(1, logs.size()).forEach(i -> {
				result.append(SEPARATEUR);
				result.append(logs.get(i).getId());
			});
		}
		return result.toString();
	}

	public static String eventsToJson(List<Events> events) {
		return new Gson().toJson(events);
	}

	public static List<Events> sendRequestToApi(String message, String mode) throws IOException {
		RestTemplate rt = new RestTemplate(); 
	    UriComponents builder = UriComponentsBuilder.fromHttpUrl(URL_API)
                .queryParam("mode",mode).build();
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		HttpEntity<String> request = new HttpEntity<>(message,headers);
		ResponseEntity<Events[]> events=rt.postForEntity(builder.toUriString(), message, Events[].class);
		 //= rt.postForEntity(URL_API, request, );
		// events.getBody();
		return Arrays.asList(events.getBody());
	}
}
