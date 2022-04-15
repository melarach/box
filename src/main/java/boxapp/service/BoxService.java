package boxapp.service;

import org.springframework.stereotype.Service;

import boxapp.model.Events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
public class BoxService {

    public List<Events> decrypt(String message) {
        List<Events> logs = new ArrayList<>();
        byte[] decodedBytes = Base64.getDecoder().decode(message);
        String decodedString = new String(decodedBytes);   
        String[] array = decodedString.split(Utils.SEPARATEUR);
        Arrays.stream(array).forEach(log -> logs.add(new Events(log)));
        return logs;
    }
}
