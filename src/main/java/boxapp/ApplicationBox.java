package boxapp;

import controler.BoxApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import service.BoxService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {BoxApi.class, BoxService.class})
public class ApplicationBox {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBox.class, args);
    }
}