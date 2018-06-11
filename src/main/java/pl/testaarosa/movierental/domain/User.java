package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "RENTAL_USER") -> only for heroku
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime registerDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DETAILS_ID")
    private UserDetails userDetails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MovieWish> movieWishes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMovie> userMovies = new ArrayList<>();

    public User() {
    }

    private User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.email = userBuilder.email;
        this.registerDate = userBuilder.registerDate;
        this.userDetails = userBuilder.userDetails;
        this.movieWishes = new ArrayList<>(userBuilder.movieWishes);
        this.userMovies = new ArrayList<>(userBuilder.userMovies);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", userDetails=" + userDetails +

                '}';
    }

    public void setMovieWishes(List<MovieWish> movieWishes) {
        this.movieWishes = movieWishes;
    }

    public void setUserMovies(List<UserMovie> userMovies) {
        this.userMovies = userMovies;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public List<MovieWish> getMovieWishes() {
        return movieWishes;
    }

    public List<UserMovie> getUserMovies() {
        return userMovies;
    }

    public static NeedName builder(){
        return new UserBuilder();
    }

    private static class UserBuilder implements NeedName,NeedSurname,NeedEmail, NeedRegisterDate, CanBeBuild {
        private String name;
        private String surname;
        private String email;
        private UserDetails userDetails;
        private LocalDateTime registerDate;
        private List<MovieWish> movieWishes = new ArrayList<>();
        private List<UserMovie> userMovies = new ArrayList<>();

        @Override
        public UserBuilder name(String name){
            this.name = name;
            return this;
        }

        @Override
        public UserBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        @Override
        public UserBuilder email(String email){
            this.email = email;
            return this;
        }

        @Override
        public UserBuilder userDetails(UserDetails userDetails){
            this.userDetails = userDetails;
            return this;
        }

        @Override
        public UserBuilder registerDate(LocalDateTime registerDate){
            this.registerDate = registerDate;
            return this;
        }

        @Override
        public UserBuilder movieWishes(MovieWish movieWish) {
            this.movieWishes.add(movieWish);
            return this;
        }

        @Override
        public UserBuilder userMovies(UserMovie userMovie) {
            this.userMovies.add(userMovie);
            return this;
        }

        @Override
        public UserBuilder and() {
            return this;
        }

        @Override
        public User build(){
            return new User(this);
        }
    }

    public interface NeedName {
        public NeedSurname name(String name);
    }

    public interface NeedSurname {
        NeedEmail surname(String surname);
    }

    public  interface NeedEmail {
        NeedRegisterDate email(String email);
    }

    public interface NeedRegisterDate{
        NeedRegisterDate registerDate(LocalDateTime registerDate);
        CanBeBuild and();
    }

    public interface CanBeBuild {
        CanBeBuild userDetails(UserDetails userDetails);
        CanBeBuild movieWishes(MovieWish movieWish);
        CanBeBuild userMovies(UserMovie userMovie);
        User build();
    }
}
