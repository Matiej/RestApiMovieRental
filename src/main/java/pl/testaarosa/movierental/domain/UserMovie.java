package pl.testaarosa.movierental.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "UserMovie.findAllUsersMoviesForGivenUser", query = "FROM UserMovie WHERE user.id = :userId"),
        @NamedQuery(name = "UserMovie.findAllUserMoviesByTitleContaining", query = "FROM UserMovie " +
                "WHERE user.id = :userId AND title LIKE CONCAT('%',:title,'%')")
})

@Entity
@Table(name = "USER_MOVIES")
public class UserMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_MOVIE_ID")
    private String imdbID;
    private String title;
    @Enumerated(value = EnumType.STRING)
    private UserMovieGenre genre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_DETAILS_ID")
    private UserMovieDetails userMovieDetails;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public UserMovie() {
    }

    private UserMovie(UserMovieBuilder userMovieBuilder) {
        this.imdbID = userMovieBuilder.imdbID;
        this.title = userMovieBuilder.title;
        this.genre = userMovieBuilder.genre;
        this.userMovieDetails = userMovieBuilder.userMovieDetails;
        this.user = userMovieBuilder.user;
    }

    public Long getId() {
        return id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getTitle() {
        return title;
    }

    public UserMovieGenre getGenre() {
        return genre;
    }

    public User getUser() {
        return user;
    }

    public UserMovieDetails getUserMovieDetails() {
        return userMovieDetails;
    }

    public void setUserMovieDetails(UserMovieDetails userMovieDetails) {
        this.userMovieDetails = userMovieDetails;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static NeedImdbID builder() {
        return new UserMovieBuilder();
    }

    private static class UserMovieBuilder implements NeedImdbID, NeedTitle, NeedGenre, CanBuild {
        private String imdbID;
        private String title;
        private UserMovieGenre genre;
        private UserMovieDetails userMovieDetails;
        private User user;

        @Override
        public UserMovieBuilder imdbID(String imdbID) {
            this.imdbID = imdbID;
            return this;
        }

        @Override
        public UserMovieBuilder title(String title) {
            this.title = title;
            return this;
        }

        @Override
        public UserMovieBuilder genre(UserMovieGenre gener) {
            this.genre = gener;
            return this;
        }

        @Override
        public UserMovieBuilder userMovieDetails(UserMovieDetails userMovieDetails) {
            this.userMovieDetails = userMovieDetails;
            return this;
        }

        @Override
        public UserMovieBuilder user(User user) {
            this.user = user;
            return this;
        }

        @Override
        public UserMovie build() {
            return new UserMovie(this);
        }
    }

    public interface NeedImdbID {
        NeedTitle imdbID(String imdbID);
    }

    public interface NeedTitle {
        NeedGenre title(String title);
    }

    public interface NeedGenre {
        CanBuild genre(UserMovieGenre genre);
    }


    public interface CanBuild {
        CanBuild userMovieDetails(UserMovieDetails userMovieDetails);

        CanBuild user(User user);

        UserMovie build();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMovie userMovie = (UserMovie) o;
        return Objects.equals(id, userMovie.id) &&
                Objects.equals(imdbID, userMovie.imdbID) &&
                Objects.equals(title, userMovie.title) &&
                genre == userMovie.genre &&
                Objects.equals(userMovieDetails, userMovie.userMovieDetails) &&
                Objects.equals(user, userMovie.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imdbID, title, genre, userMovieDetails, user);
    }

    @Override
    public String toString() {
        return "UserMovie{" +
                "id=" + id +
                ", imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", userMovieDetails=" + userMovieDetails +
                ", user=" + user +
                '}';
    }
}
