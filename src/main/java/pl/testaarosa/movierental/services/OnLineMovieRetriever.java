package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.testaarosa.movierental.cfg.CoreConfig;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmbdOnLineDetailsDto;
import pl.testaarosa.movierental.domain.dto.OmbdOnLineDto;
import pl.testaarosa.movierental.domain.dto.OmbdOnLinePaginationDto;
import pl.testaarosa.movierental.mapper.OmbdOnLineMapper;
import pl.testaarosa.movierental.mapper.OmbdOneLineDetailsMapper;
import pl.testaarosa.movierental.supplier.OmbdMovieSupplier;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
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

    public List<OnLineMovie> getOnLineMovies(String title) {
        List<OnLineMovie> onLineMovieList = new ArrayList<>();
        try {
            IntStream.range(0, (getPagination(title) / 10)).forEach(m -> {
                URI urlpages = supplier.OmbdSupplierSource(m, title);

                OmbdOnLinePaginationDto moviepages = restTemplate.getForObject(urlpages, OmbdOnLinePaginationDto.class);
                List<OmbdOnLineDto> list = moviepages.getOmbdOnLineDtos();
                onLineMovieList.addAll(ombdOnLineMapper.mapToOnLineMovieList(list));
            });
            return onLineMovieList;
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    private int getPagination(String title) {
        URI url = supplier.OmbdSupplierSource(1, title);
        return Integer.parseInt(ofNullable(restTemplate.getForObject(url, OmbdOnLinePaginationDto.class)
                .getTotalResults()).orElse("1"));
    }

    public OnLineMovieDetails getOnLineMovieDetails(String movieId) {
        URI url = supplier.OmbdSupplierDetails(movieId);
        try {
            OnLineMovieDetails onLineMovieDetails = ombdOneLineDetailsMapper.mapToOnLineMovieDetails
                    (restTemplate.getForObject(url, OmbdOnLineDetailsDto.class));
            return ofNullable(onLineMovieDetails).orElse(new OnLineMovieDetails());
        }   catch (RestClientException e) {
            LOGGER.error(e.getMessage(),e);
            return new OnLineMovieDetails();
        }
    }
}
