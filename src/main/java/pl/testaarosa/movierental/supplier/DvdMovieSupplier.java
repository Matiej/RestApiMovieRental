package pl.testaarosa.movierental.supplier;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DvdMovieSupplier {

    public List<String> DvdSupplierSource() throws URISyntaxException, IOException {

        List<String> lines = Files.readAllLines(Paths.get("supOneMovies.txt"));
        System.out.println("MATIEJ-LINES FOUNDEREK ##############################" +lines);
        return lines;

    }
}
