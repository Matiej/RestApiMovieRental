package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserMovieDetails;
import pl.testaarosa.movierental.domain.UserMovieGenre;

public class UserMovieDto {

    private Long id;
    private String imdbID;
    private String title;
    private UserMovieGenre genre;
    private UserMovieDetails userMovieDetails;
    private User user;

    public UserMovieDto(Long id, String imdbID, String title, UserMovieGenre genre, UserMovieDetails userMovieDetails, User user) {
        this.id = id;
        this.imdbID = imdbID;
        this.title = title;
        this.genre = genre;
        this.userMovieDetails = userMovieDetails;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserMovieGenre getGenre() {
        return genre;
    }

    public void setGenre(UserMovieGenre genre) {
        this.genre = genre;
    }

    public UserMovieDetails getUserMovieDetails() {
        return userMovieDetails;
    }

    public void setUserMovieDetails(UserMovieDetails userMovieDetails) {
        this.userMovieDetails = userMovieDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
