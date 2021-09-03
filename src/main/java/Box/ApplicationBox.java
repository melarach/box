package Box;

import controler.BoxApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = BoxApi.class)
public class ApplicationBox {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBox.class, args);
    }
}