package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmbdBlueRayDetailsDto;
import pl.testaarosa.movierental.domain.dto.OmbdBlueRayPaginationDto;
import pl.testaarosa.movierental.mapper.OmbdBlueRayDetailsMapper;
import pl.testaarosa.movierental.mapper.OmbdBlueRayMapper;
import pl.testaarosa.movierental.supplier.OmbdMovieSupplier;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.Optional.ofNullable;

@Service
public class BlueRayMovieRetriever {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlueRayMovieRetriever.class);

    @Autowired
    private OmbdMovieSupplier supplier;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OmbdBlueRayMapper movieMapper;
    @Autowired
    private OmbdBlueRayDetailsMapper detailsMapper;

    @Async
    public CompletableFuture<List<BlueRayMovie>> getPaginationBlueRay(String title) throws InterruptedException {
        URI url = supplier.OmbdSupplierSource(1, title);

        try {
            LOGGER.info("\033[33m Loooking for movies: " + title);
            OmbdBlueRayPaginationDto ombdBlueRayPaginationDto = restTemplate.getForObject(url, OmbdBlueRayPaginationDto.class);
            List<BlueRayMovie> blueRayMovie = movieMapper.mapToBlueRayMoviesList(ombdBlueRayPaginationDto.getOmbdBlueRayDtos());
            //TODO wywalic to. Tylko dla sprawdzenia czy działa
//            Thread.sleep(10000L);
            return CompletableFuture.completedFuture(ofNullable(blueRayMovie).orElse(new ArrayList<>()));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(),e);
            return new CompletableFuture<>();
        }
    }

    @Async
    public CompletableFuture<BlueRayMovieDetails> getMovieDetails(String movieId) {
        LOGGER.info("\033[33m Looking for movie id: " + movieId + " \033[33m details");
        URI url = supplier.OmbdSupplierDetails(movieId);

        try {
            OmbdBlueRayDetailsDto details = restTemplate.getForObject(url, OmbdBlueRayDetailsDto.class);
            BlueRayMovieDetails movieDetails = detailsMapper.mapToBlueRayMovieDetails(details);
            return CompletableFuture.completedFuture(ofNullable(movieDetails).orElse(new BlueRayMovieDetails()));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new CompletableFuture<>();
        }
    }
}
