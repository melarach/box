package controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.Events;
import service.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@RestController
public class BoxApi {

    @GetMapping("/decrypt")
    public List<Events> decrypt(@RequestParam(value = "message")String message, @RequestParam(value = "mode")String mode){
        List<Events> logs=new ArrayList<>();
        byte[] decodedBytes = Base64.getDecoder().decode(message);
        String decodedString = new String(decodedBytes);
        String[] array = decodedString.split(Utils.SEPARATEUR);
        Arrays.stream(array).forEach(log -> {
            logs.add(new Events(log));
        });
        return logs;
    }




}
