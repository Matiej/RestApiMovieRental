package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RENTAL_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @ManyToMany(mappedBy = "userList", cascade = CascadeType.ALL)
    private List<UserMovie> userMovies = new ArrayList<>();

    public User() {
    }

    private User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.email = userBuilder.email;
        this.userDetails = userBuilder.userDetails;
        this.registerDate = userBuilder.registerDate;
        this.movieWishes = new ArrayList<>(userBuilder.movieWishes);
        this.userMovies = new ArrayList<>(userBuilder.userMovies);
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

    public static class UserBuilder{
        private String name;
        private String surname;
        private String email;
        private UserDetails userDetails;
        private LocalDateTime registerDate;
        private List<MovieWish> movieWishes = new ArrayList<>();
        private List<UserMovie> userMovies = new ArrayList<>();

        public UserBuilder name(String name){
            this.name = name;
            return this;
        }

        public UserBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        public UserBuilder email(String email){
            this.email = email;
            return this;
        }

        public UserBuilder userDetails(UserDetails userDetails){
            this.userDetails = userDetails;
            return this;
        }

        public UserBuilder registerDate(LocalDateTime registerDate){
            this.registerDate = registerDate;
            return this;
        }

        public UserBuilder movieWishes(MovieWish movieWish) {
            this.movieWishes.add(movieWish);
            return this;
        }

        public UserBuilder userMovies(UserMovie userMovie) {
            this.userMovies.add(userMovie);
            return this;
        }

        public User build(){
            return new User(this);
        }

        @Override
        public String toString() {
            return "UserBuilder{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", email='" + email + '\'' +
                    ", userDetails=" + userDetails +
                    ", registerDate=" + registerDate +
                    '}';
        }
    }
}
