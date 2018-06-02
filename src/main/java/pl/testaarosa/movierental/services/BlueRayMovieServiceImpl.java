package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;
import pl.testaarosa.movierental.repositories.BlueRayMovieRepository;

import java.util.List;

@Service
public class BlueRayMovieServiceImpl implements BlueRayMovieService {

    @Autowired
    private BlueRayMovieRepository blueRayMovieRepository;

    public void addBlueRayMovies(BlueRayMovie blueRayMovie,
                                 BlueRayMovieDetails blueRayMovieDetails) {
        String imdbID = blueRayMovie.getImdbID();
        if(!blueRayMovieRepository.existsAllByImdbID(imdbID)){
            BlueRayMovie movieFromTwo = blueRayMovie;
            movieFromTwo.setBlueRayMovieDetails(blueRayMovieDetails);
            blueRayMovieRepository.save(movieFromTwo);
        }
    }

    @Override
    public List<BlueRayMovie> findAll(){
        return blueRayMovieRepository.findAll();
    }

    @Override
    public BlueRayMovie findbyId(Long id){
        return blueRayMovieRepository.findOne(id);
    }

    @Override
    public List<BlueRayMovie> findAllContainsTitle(String title){
        return blueRayMovieRepository.findAllByTitleContaining(title);
    }

}
