package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;
import pl.testaarosa.movierental.repositories.BlueRayMovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlueRayMovieServiceImpl implements BlueRayMovieService {

    private final static Logger LOGGER = LoggerFactory.getLogger(BlueRayMovieServiceImpl.class);
    @Autowired
    private BlueRayMovieRepository blueRayMovieRepository;

    public BlueRayMovie addBlueRayMovies(BlueRayMovie blueRayMovie, BlueRayMovieDetails blueRayMovieDetails) {
        String imdbID = blueRayMovie.getImdbID();
        BlueRayMovie blueRayMovie1 = new BlueRayMovie();
        if(!blueRayMovieRepository.existsAllByImdbID(imdbID)){
            blueRayMovie1 = blueRayMovie;
            blueRayMovie1.setBlueRayMovieDetails(blueRayMovieDetails);
            blueRayMovieRepository.save(blueRayMovie1);
        }
        return blueRayMovie1;
    }

    @Override
    public List<BlueRayMovie> findAll(){
        return blueRayMovieRepository.findAll();
    }

    @Override
    public BlueRayMovie findbyId(Long id) throws MovieNotFoundException {
        BlueRayMovie blueRayMovie = null;
        if(Optional.ofNullable(blueRayMovieRepository.findOne(id)).isPresent()) {
            blueRayMovie = blueRayMovieRepository.findOne(id);
            return blueRayMovie;
        } else {
            LOGGER.error("\u001B[31mNo blueray movie found!!\u001B[0m");
            throw new MovieNotFoundException("No bluray movie found");
        }
    }

    @Override
    public List<BlueRayMovie> findAllContainsTitle(String title){
        return blueRayMovieRepository.findAllByTitleContaining(title);
    }

}
