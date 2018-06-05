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
    @Autowired
    private DvdMovieSupplier supplier;

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalApplication.class, args);
    }

    public void run(String... strings) throws Exception {

//        dvdMovieFillDbProcessor.FillDvdMovieDb();
        System.out.println(supplier.DvdSupplierSource());
        blueRayMovieFillDbProcessor.FillBlueRayDb("iron");
        blueRayMovieFillDbProcessor.FillBlueRayDb("list");
        blueRayMovieFillDbProcessor.FillBlueRayDb("star");
        blueRayMovieFillDbProcessor.FillBlueRayDb("indiana");
    }
}
