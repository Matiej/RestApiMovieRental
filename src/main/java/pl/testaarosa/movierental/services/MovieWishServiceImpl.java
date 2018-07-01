package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.repositories.MovieRepository;
import pl.testaarosa.movierental.repositories.MovieWishRepository;

import java.util.List;

@Service
public class MovieWishServiceImpl {

    @Autowired
    private MovieWishRepository movieWishRepository;
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieWish> findAllWishes() {
        return movieWishRepository.findAll();
    }

    public MovieWish createMowieWish(User user) {
        MovieWish movieWish = new MovieWish();
        movieWish.setUser(user);
        return movieWishRepository.save(movieWish);
    }

    public MovieWish addMovie(Movie movie) {
        MovieWish one = movieWishRepository.findOne(1L);
        one.getMoviesList().add(movie);
        return movieWishRepository.save(one);
    }

    public MovieWish findById(Long id) {
        return movieWishRepository.findOne(id);
    }

    public Movie findMovieById(Long id) {
        return movieRepository.findOne(id);
    }




}
