package pl.testaarosa.movierental.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.repositories.MovieRepository;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findById(Long id) throws MovieNotFoundException {
        if(Optional.ofNullable(movieRepository.findOne(id)).isPresent()) {
            return movieRepository.findOne(id);
        } else {
            LOGGER.error("\u001B[31mNo movie found!!\u001B[0m");
            throw new MovieNotFoundException("No movie found");
        }
    }
}
