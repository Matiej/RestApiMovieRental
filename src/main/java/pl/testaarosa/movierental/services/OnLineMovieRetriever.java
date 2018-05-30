package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.supplier.OnLineMovieSupplier;

import java.util.ArrayList;
import java.util.List;

@Service
public class OnLineMovieRetriever {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private OnLineMovieSupplier supplier;

    public List<OnLineMovieDto> getPaginationOnlineLine(String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = supplier.OnlineSupplierSource(1, title);
        OnLineMoviePaginationDto movie = restTemplate.getForObject(url, OnLineMoviePaginationDto.class);
        int totalResults = Integer.parseInt(movie.getTotalResults())/10;
        List<OnLineMovieDto> dtos = new ArrayList<>();
        for(int i = 1; i<= totalResults; i++){
            String urlpages = supplier.OnlineSupplierSource(i, title);
            OnLineMoviePaginationDto moviepages = restTemplate.getForObject(urlpages, OnLineMoviePaginationDto.class);
            dtos.addAll(moviepages.getOnLineMovieDtos());
        }
        return dtos;
    }

    public OnLineMovieDetailsDto getOnLineMovieDetails(String movieId){
        String url = supplier.OnLineSourceDetail(movieId);
        return restTemplate.getForObject(url, OnLineMovieDetailsDto.class);
    }
}
