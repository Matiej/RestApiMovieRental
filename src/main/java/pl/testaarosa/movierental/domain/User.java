package pl.testaarosa.movierental.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "User.findRemoteUser", query = "FROM User " +
                "WHERE email = :remoteUser")})

@Entity
@Table(name = "RENTAL_USER")
public class User implements org.springframework.security.core.userdetails.UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String matchingPassword;
    private boolean enabled;
    private LocalDateTime registerDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DETAILS_ID")
    private UserRentalDetails userRentalDetails;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MovieWish> movieWishes = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMovie> userMovies = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    public User() {
    }

    private User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.password = userBuilder.password;
        this.matchingPassword = userBuilder.matchingPassword;
        this.enabled = userBuilder.enabled;
        this.email = userBuilder.email;
        this.registerDate = userBuilder.registerDate;
        this.userRentalDetails = userBuilder.userRentalDetails;
        this.movieWishes = new ArrayList<>(userBuilder.movieWishes);
        this.userMovies = new ArrayList<>(userBuilder.userMovies);
        this.role = userBuilder.role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                ", enabled=" + enabled +
                ", registerDate=" + registerDate +
                ", userRentalDetails=" + userRentalDetails +
                ", movieWishes=" + movieWishes +
                ", userMovies=" + userMovies +
                ", role=" + role +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", email='" + email + '\'' +
//                ", registerDate=" + registerDate +
//                ", userRentalDetails=" + userRentalDetails +
//
//                '}';
//    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setMovieWishes(List<MovieWish> movieWishes) {
        this.movieWishes = movieWishes;
    }

    public void setUserMovies(List<UserMovie> userMovies) {
        this.userMovies = userMovies;
    }

    public void setUserRentalDetails(UserRentalDetails userRentalDetails) {
        this.userRentalDetails = userRentalDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean enabled() {
        return enabled;
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

    public UserRentalDetails getUserRentalDetails() {
        return userRentalDetails;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(matchingPassword, user.matchingPassword) &&
                Objects.equals(registerDate, user.registerDate) &&
                Objects.equals(userRentalDetails, user.userRentalDetails) &&
                Objects.equals(movieWishes, user.movieWishes) &&
                Objects.equals(userMovies, user.userMovies) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, matchingPassword, enabled, registerDate, userRentalDetails, movieWishes, userMovies);
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Role getRole() {
        return role;
    }

    public static NeedName builder(){
        return new UserBuilder();
    }

    private static class UserBuilder implements NeedName,NeedSurname,NeedEmail, NeedPassword, NeedMatchingPassword, NeedRegisterDate, CanBeBuild {
        private String name;
        private String surname;
        private String email;
        private String password;
        private String matchingPassword;
        private boolean enabled;
        private UserRentalDetails userRentalDetails;
        private LocalDateTime registerDate;
        private List<MovieWish> movieWishes = new ArrayList<>();
        private List<UserMovie> userMovies = new ArrayList<>();
        private Role role;

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
        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        @Override
        public NeedRegisterDate matchingpassword(String matchingPassword) {
            this.matchingPassword = matchingPassword;
            return this;
        }

        @Override
        public UserBuilder enabled(boolean enabled){
            this.enabled = enabled;
            return this;
        }

        @Override
        public UserBuilder userDetails(UserRentalDetails userRentalDetails){
            this.userRentalDetails = userRentalDetails;
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
        public UserBuilder role(Role role) {
            this.role = role;
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
        NeedPassword email(String email);
    }

    public interface NeedPassword {
        NeedMatchingPassword password(String password);
    }

    public interface NeedMatchingPassword {
        NeedRegisterDate matchingpassword(String matchingpassword);
    }

    public interface NeedRegisterDate{
        CanBeBuild registerDate(LocalDateTime registerDate);
    }

    public interface CanBeBuild {
        CanBeBuild enabled(boolean enabled);
        CanBeBuild userDetails(UserRentalDetails userRentalDetails);
        CanBeBuild movieWishes(MovieWish movieWish);
        CanBeBuild userMovies(UserMovie userMovie);
        CanBeBuild role(Role role);
        User build();
    }
}
