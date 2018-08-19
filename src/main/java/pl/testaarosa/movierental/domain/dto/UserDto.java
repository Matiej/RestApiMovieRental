package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.MovieWish;
import pl.testaarosa.movierental.domain.Role;
import pl.testaarosa.movierental.domain.UserRentalDetails;
import pl.testaarosa.movierental.domain.UserMovie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String matchingPassword;
    private boolean isEnabled;
    private LocalDateTime registerDate;
    private UserRentalDetails userRentalDetails;
    private List<MovieWish> movieWishes = new ArrayList<>();
    private List<UserMovie> userMovies = new ArrayList<>();
    private Role role;

    public UserDto(Long id, String name, String surname, String email, String password, String matchingPassword, boolean isEnabled, LocalDateTime registerDate,
                   UserRentalDetails userRentalDetails, List<MovieWish> movieWishes, List<UserMovie> userMovies, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.isEnabled = isEnabled;
        this.registerDate = registerDate;
        this.userRentalDetails = userRentalDetails;
        this.movieWishes = movieWishes;
        this.userMovies = userMovies;
        this.role = role;
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

    public UserRentalDetails getUserRentalDetails() {
        return userRentalDetails;
    }

    public void setUserRentalDetails(UserRentalDetails userRentalDetails) {
        this.userRentalDetails = userRentalDetails;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
