package pl.testaarosa.movierental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MovieRentalApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalApplication.class, args);
    }

}

