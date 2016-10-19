package nl.hro.assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Java application for loading in a bunch of models in a MongoDB Document database.
 *
 * @author Marcel Hollink
 * @version 0.0.1
 * @since 18-10-2016
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
