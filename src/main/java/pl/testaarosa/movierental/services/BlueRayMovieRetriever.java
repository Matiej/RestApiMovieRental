package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.supplier.OmbdMovieSupplier;

import java.net.URI;

@Service
public class BlueRayMovieRetriever {
    @Autowired
    private OmbdMovieSupplier supplier;
    @Autowired
    private RestTemplate restTemplate;

    public BlueRayMoviePaginationDto getPaginationBlueRay(String title) {
        URI url = supplier.OmbdSupplierSource(1, title);
        return restTemplate.getForObject(url, BlueRayMoviePaginationDto.class);
    }

    public BlueRayMovieDetailsDto getMovieDetails(String movieId) {
        URI url = supplier.OmbdSupplierDetails(movieId);
        return restTemplate.getForObject(url, BlueRayMovieDetailsDto.class);
    }


}
