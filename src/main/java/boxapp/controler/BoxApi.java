package boxapp.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boxapp.model.Events;
import boxapp.service.BoxService;

@RestController
public class BoxApi {
    @Autowired
    private BoxService boxService;

    @PostMapping("/decrypt")
    public List<Events> decrypt(@RequestBody String message, @RequestParam(value = "mode") String mode) {
        return boxService.decrypt(message);
    }


}
