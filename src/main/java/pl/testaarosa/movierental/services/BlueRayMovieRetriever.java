package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.supplier.BlueRayMovieSupplier;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlueRayMovieRetriever {
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private BlueRayMovieSupplier supplier = new BlueRayMovieSupplier();

    public BlueRayMoviePaginationDto getPaginationBlueRay(String title) {
        String url = supplier.blueRaySupplierSource(1, title);
        return restTemplate.getForObject(url, BlueRayMoviePaginationDto.class);
    }


    public BlueRayMovieDetailsDto getMovieDetails(String movieId) {
        String url = supplier.blueRaySourceDetail(movieId);
        BlueRayMovieDetailsDto movieDetails = new BlueRayMovieDetailsDto();
        movieDetails = restTemplate.getForObject(url, BlueRayMovieDetailsDto.class);
        return movieDetails;
    }


}
