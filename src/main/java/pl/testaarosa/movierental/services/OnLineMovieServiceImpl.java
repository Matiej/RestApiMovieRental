package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDetailsDto;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.mapper.BlueRayMovieDetailsMapper;
import pl.testaarosa.movierental.mapper.BlueRayMovieMapper;

import java.util.List;

@Service
public class OnLineMovieServiceImpl implements OnLineMovieService {

    @Autowired
    private BlueRayMovieDetailsMapper blueRayDetailsMapper;
    @Autowired
    private BlueRayMovieMapper blueRayMovieMapper;
    @Autowired
    private BlueRayMovieRetriver blueRayMovieRetriver;

    @Override
    public List<BlueRayMovie> getOnLineMovies(String title){
        List<BlueRayMovieDto> movieTwoDtoList = blueRayMovieRetriver.getPaginationBlueRay(title)
                .getBlueRayMovieDtos();
        return blueRayMovieMapper.mapToBlueRayMoviesList(movieTwoDtoList);
    }

    @Override
    public BlueRayMovieDetails getOnLineMovieDetails(String movieId){
        BlueRayMovieDetailsDto movieDetails = blueRayMovieRetriver.getMovieDetails(movieId);
        return blueRayDetailsMapper.mapToMovieFromSupplierTwoDetails(movieDetails);
    }

}
