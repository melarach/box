package controler;

import model.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.BoxService;

import java.util.List;

@RestController
public class BoxApi {
    @Autowired
    private BoxService boxService;

    @GetMapping("/decrypt")
    public List<Events> decrypt(@RequestParam(value = "message") String message, @RequestParam(value = "mode") String mode) {
        return boxService.decrypt(message);
    }


}
