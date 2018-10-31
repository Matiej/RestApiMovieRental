package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.dto.OneDvdDto;
import pl.testaarosa.movierental.supplier.DvdMovieSupplier;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class DvdMovieRetriver {

    private static final Logger LOGGER = LoggerFactory.getLogger(DvdMovieRetriver.class);

    @Autowired
    private DvdMovieSupplier dvdMovieSupplier;

    @Async
    public CompletableFuture<List<OneDvdDto>> dvdFillStructure() throws IOException, URISyntaxException {
        LOGGER.info("\033[35m Lokiing up for DVDS \033[0m");
        List<OneDvdDto> dvdMovies = new ArrayList<>();
        List<String> lines = dvdMovieSupplier.DvdSupplierSource();
        lines.remove(0);
        lines.forEach(l-> {
            String[] value = l.split("\t");
            OneDvdDto oneDvdDto = new OneDvdDto.Builder()
                    .movieId(value[0])
                    .title(value[1])
                    .countryOfOrigin(value[2])
                    .filmGenre(value[3])
                    .price(Double.parseDouble(value[4]))
                    .build();
            dvdMovies.add(oneDvdDto);
        });
        return CompletableFuture.completedFuture(dvdMovies);
    }
}
