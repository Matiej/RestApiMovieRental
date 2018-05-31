package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.supplier.OnLineMovieSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class OnLineMovieRetriever {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private OnLineMovieSupplier supplier;

    public List<OnLineMovieDto> getPaginationOnlineLine(String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = supplier.OnlineSupplierSource(1, title);
        OnLineMoviePaginationDto movie = restTemplate.getForObject(url, OnLineMoviePaginationDto.class);
        int totalResults = Integer.parseInt(movie.getTotalResults()) / 10;
        List<OnLineMovieDto> onLineMovieDtoList = new ArrayList<>();
        IntStream.range(0, totalResults).forEach(m -> {
                    String urlpages = supplier.OnlineSupplierSource(m, title);
                    OnLineMoviePaginationDto moviepages = restTemplate.getForObject(urlpages, OnLineMoviePaginationDto.class);
                    onLineMovieDtoList.addAll(moviepages.getOnLineMovieDtos());
                }
        );
        return onLineMovieDtoList;
    }

    public OnLineMovieDetailsDto getOnLineMovieDetails(String movieId) {
        String url = supplier.OnLineSourceDetail(movieId);
        return restTemplate.getForObject(url, OnLineMovieDetailsDto.class);
    }
}
