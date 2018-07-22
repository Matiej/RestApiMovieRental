package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.Movie;
import pl.testaarosa.movierental.domain.User;

import java.util.ArrayList;
import java.util.List;

public class MovieWishDto {

    private Long id;
    private String wishName;
    private List<Movie> moviesList = new ArrayList<>();
    private User user;

    public MovieWishDto(Long id, String wishName, List<Movie> moviesList, User user) {
        this.id = id;
        this.wishName = wishName;
        this.moviesList = moviesList;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
