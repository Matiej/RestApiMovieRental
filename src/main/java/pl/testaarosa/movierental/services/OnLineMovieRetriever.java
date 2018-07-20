package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmdbOnLineDetailsDto;
import pl.testaarosa.movierental.domain.dto.OmdbOnLineDto;
import pl.testaarosa.movierental.domain.dto.OmdbOnLinePaginationDto;
import pl.testaarosa.movierental.mapper.OmbdOnLineMapper;
import pl.testaarosa.movierental.mapper.OmbdOneLineDetailsMapper;
import pl.testaarosa.movierental.supplier.OmbdMovieSupplier;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

import static java.util.Optional.ofNullable;

@Service
public class OnLineMovieRetriever {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlueRayMovieRetriever.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OmbdMovieSupplier supplier;
    @Autowired
    private OmbdOnLineMapper ombdOnLineMapper;
    @Autowired
    private OmbdOneLineDetailsMapper ombdOneLineDetailsMapper;

    @Async
    public CompletableFuture<List<OnLineMovie>> getOnLineMovies(String title) {
        LOGGER.info("\033[33m Loooking for movie: " + title);
        List<OnLineMovie> onLineMovieList = new ArrayList<>();
        try {
            IntStream.range(0, (getPagination(title) / 10)).forEach(m -> {
                URI urlpages = supplier.OmbdSupplierSource(m, title);

                OmdbOnLinePaginationDto moviepages = restTemplate.getForObject(urlpages, OmdbOnLinePaginationDto.class);
                List<OmdbOnLineDto> list = moviepages.getOmdbOnLineDtos();
                onLineMovieList.addAll(ombdOnLineMapper.mapToOnLineMovieList(list));
            });
            return CompletableFuture.completedFuture(ofNullable(onLineMovieList).orElse(new ArrayList<>()));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new CompletableFuture<>();
        }
    }

    private int getPagination(String title) {
        URI url = supplier.OmbdSupplierSource(1, title);
        return Integer.parseInt(ofNullable(restTemplate.getForObject(url, OmdbOnLinePaginationDto.class)
                .getTotalResults()).orElse("1"));

        //specjalnie zrobione tak aby podzielić ilośc wyników. Strona ombd przy duzej ilosc stron
        //zawiesza się i nic nie znajduje.
//        if(pages >= 1) {
//            return pages;
//        } else {
//
//            return pages/2;
//        }
    }
    @Async
    public CompletableFuture<OnLineMovieDetails> getOnLineMovieDetails(String movieId) {
        LOGGER.info("\033[33m Loooking for movie ID: " + movieId);
        URI url = supplier.OmbdSupplierDetails(movieId);
        try {
            OnLineMovieDetails onLineMovieDetails = ombdOneLineDetailsMapper.mapToOnLineMovieDetails
                    (restTemplate.getForObject(url, OmdbOnLineDetailsDto.class));
            return CompletableFuture.completedFuture(ofNullable(onLineMovieDetails).orElse(new OnLineMovieDetails()));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new CompletableFuture<>();
        }
    }
}
