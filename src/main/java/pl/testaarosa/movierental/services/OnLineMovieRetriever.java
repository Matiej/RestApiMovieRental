package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.supplier.OmbdMovieSupplier;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class OnLineMovieRetriever {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OmbdMovieSupplier supplier;

    public List<OnLineMovieDto> getPaginationOnlineLine(String title) {
        RestTemplate restTemplate = new RestTemplate();
        URI url = supplier.OmbdSupplierSource(1, title);
        OnLineMoviePaginationDto movie = restTemplate.getForObject(url, OnLineMoviePaginationDto.class);
        int totalResults = Integer.parseInt(movie.getTotalResults()) / 10;
        List<OnLineMovieDto> onLineMovieDtoList = new ArrayList<>();
        IntStream.range(0, totalResults).forEach(m -> {
                    URI urlpages = supplier.OmbdSupplierSource(m, title);
                    OnLineMoviePaginationDto moviepages = restTemplate.getForObject(urlpages, OnLineMoviePaginationDto.class);
                    onLineMovieDtoList.addAll(moviepages.getOnLineMovieDtos());
                }
        );
        return onLineMovieDtoList;
    }

    public OnLineMovieDetailsDto getOnLineMovieDetails(String movieId) {
        URI url = supplier.OmbdSupplierDetails(movieId);
        return restTemplate.getForObject(url, OnLineMovieDetailsDto.class);
    }
}
