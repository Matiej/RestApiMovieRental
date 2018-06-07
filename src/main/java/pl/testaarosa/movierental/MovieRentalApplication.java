package pl.testaarosa.movierental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.testaarosa.movierental.services.DvdMovieFillDbProcessor;
import pl.testaarosa.movierental.services.BlueRayMovieFillDbProcessor;
import pl.testaarosa.movierental.supplier.DvdMovieSupplier;

@SpringBootApplication
public class MovieRentalApplication implements CommandLineRunner {

    @Autowired
    private DvdMovieFillDbProcessor dvdMovieFillDbProcessor;
    @Autowired
    private BlueRayMovieFillDbProcessor blueRayMovieFillDbProcessor;

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalApplication.class, args);
    }

    public void run(String... strings) throws Exception {

//        blueRayMovieFillDbProcessor.FillBlueRayDb("list");
        blueRayMovieFillDbProcessor.FillBlueRayDb("iron");
        dvdMovieFillDbProcessor.FillDvdMovieDb();
        blueRayMovieFillDbProcessor.FillBlueRayDb("star");
//        blueRayMovieFillDbProcessor.FillBlueRayDb("indiana");
    }
}
