package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "MovieWish.findAllUsersWishForGivenUser", query = "FROM MovieWish WHERE user.id = :userId"),
})

@Entity
@Table(name = "MOVIES_WISH")
public class MovieWish {
//TODO builder idiotoodportnego zrobić
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String wishName;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "JOIN_WISH_MOVIE",
    joinColumns = {@JoinColumn(name = "WISH_ID", referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name = "MOVIES_ID", referencedColumnName = "ID")})
    private List<Movie> moviesList = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    public MovieWish() {
    }

    private MovieWish(MovieWishBuilder movieWishBuilder) {
        this.wishName = movieWishBuilder.wishName;
        this.moviesList = new ArrayList<>(movieWishBuilder.moviesList);
        this.user = movieWishBuilder.user;
    }

    public Long getId() {
        return id;
    }

    public String getWishName() {
        return wishName;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    public static class MovieWishBuilder {
        private String wishName;
        private List<Movie> moviesList = new ArrayList<>();
        private User user;

        public MovieWishBuilder wishName(String wishName) {
            this.wishName = wishName;
            return this;
        }

        public MovieWishBuilder movieList(List<Movie> movieList) {
            this.moviesList = movieList;
            return this;
        }

        public MovieWishBuilder user(User user) {
            this.user = user;
            return this;
        }

        public MovieWish builder() {
            return new MovieWish(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieWish movieWish = (MovieWish) o;
        return Objects.equals(id, movieWish.id) &&
                Objects.equals(wishName, movieWish.wishName) &&
                Objects.equals(moviesList, movieWish.moviesList) &&
                Objects.equals(user, movieWish.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wishName, moviesList, user);
    }

    @Override
    public String toString() {
        return "MovieWish{" +
                "id=" + id +
                ", wishName='" + wishName + '\'' +
                ", moviesList=" + moviesList +
                ", user=" + user +
                '}';
    }
}
