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
public class BlueRayMovieFillDbProcessor {
    @Autowired
    private BlueRayMovieRetriever moSuppTwoRetriver;
    @Autowired
    private BlueRayMovieService blueRayMovieService;
    @Autowired
    private BlueRayMovieMapper blueRayMovieMapper;
    @Autowired
    private BlueRayMovieDetailsMapper twoDetailsMapper;

    public void FillBlueRayDb(String title) {
        List<BlueRayMovieDto> movieTwoDtoList = moSuppTwoRetriver.getPaginationBlueRay(title).getBlueRayMovieDtos();
        for (BlueRayMovieDto blueRayMovieDto : movieTwoDtoList) {
            BlueRayMovie blueRayMovie = blueRayMovieMapper.mapToMovieFromSupplierTwo(blueRayMovieDto);
            String imdbID = blueRayMovie.getImdbID();
            BlueRayMovieDetails movDetaTwo = twoDetailsMapper.mapToMovieFromSupplierTwoDetails(getDet(imdbID));
            blueRayMovieService.addBlueRayMovies(blueRayMovie, movDetaTwo);
        }
    }

    private BlueRayMovieDetailsDto getDet(String moiveId) {
        return moSuppTwoRetriver.getMovieDetails(moiveId);
    }
}
