package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDetailsDto;
import pl.testaarosa.movierental.domain.dto.BlueRayMoviePaginationDto;
import pl.testaarosa.movierental.supplier.BlueRayMovieSupplier;

@Service
public class BlueRayMovieRetriver {

    @Autowired
    private BlueRayMovieSupplier blueRayMovieSupplier = new BlueRayMovieSupplier();

    public BlueRayMoviePaginationDto getPaginationBlueRay(String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = blueRayMovieSupplier.BlueRaySupplierSource(1,title);
        BlueRayMoviePaginationDto movieTwo  = restTemplate
                .getForObject(url, BlueRayMoviePaginationDto.class);
        return movieTwo;
    }

    public BlueRayMovieDetailsDto getMovieDetails(String movieId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = blueRayMovieSupplier.BlueRaySourceDetail(movieId);
        BlueRayMovieDetailsDto movieDetails = new BlueRayMovieDetailsDto();
        movieDetails = restTemplate.getForObject(url, BlueRayMovieDetailsDto.class);
        return movieDetails;
    }


}
