package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MOVIES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imdbID;
    private String poster;
    private String supplier;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "moviesList", targetEntity = MovieWish.class)
    private List<MovieWish> movieWishList = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, String imdbID, String poster, String supplier) {
        this.title = title;
        this.imdbID = imdbID;
        this.poster = poster;
        this.supplier = supplier;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public List<MovieWish> getMovieWishList() {
        return movieWishList;
    }

    public void setMovieWishList(List<MovieWish> movieWishList) {
        this.movieWishList = movieWishList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(imdbID, movie.imdbID) &&
                Objects.equals(poster, movie.poster) &&
                Objects.equals(supplier, movie.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, imdbID, poster, supplier);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", poster='" + poster + '\'' +
                ", supplier='" + supplier + '\'' +
                ", movieWishList=" + movieWishList +
                '}';
    }
}
