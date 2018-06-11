package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.UserDetails;
import pl.testaarosa.movierental.domain.UserMovie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime registerDate;
    private UserDetails userDetails;
    private List<MovieWish> movieWishes = new ArrayList<>();
    private List<UserMovie> userMovies = new ArrayList<>();

    public UserDto(Long id, String name, String surname, String email, LocalDateTime registerDate,
                   UserDetails userDetails, List<MovieWish> movieWishes, List<UserMovie> userMovies) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.registerDate = registerDate;
        this.userDetails = userDetails;
        this.movieWishes = movieWishes;
        this.userMovies = userMovies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<MovieWish> getMovieWishes() {
        return movieWishes;
    }

    public void setMovieWishes(List<MovieWish> movieWishes) {
        this.movieWishes = movieWishes;
    }

    public List<UserMovie> getUserMovies() {
        return userMovies;
    }

    public void setUserMovies(List<UserMovie> userMovies) {
        this.userMovies = userMovies;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
