package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BLUE_RAY_MOVIES")
public class BlueRayMovie implements Movies{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String year;
    private String imdbID;
    private String type;
    private String poster;
    private String supplier;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DETAILS_ID")
    private BlueRayMovieDetails blueRayMovieDetails;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "blueRayMovies", targetEntity = MovieWish.class)
    private List<MovieWish> movieWishList = new ArrayList<>();


    public BlueRayMovie() {
    }

    public BlueRayMovie(String title, String year, String imdbID, String type, String poster, String supplier) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public BlueRayMovieDetails getBlueRayMovieDetails() {
        return blueRayMovieDetails;
    }

    public void setBlueRayMovieDetails(BlueRayMovieDetails blueRayMovieDetails) {
        this.blueRayMovieDetails = blueRayMovieDetails;
    }

    public List<MovieWish> getMovieWishList() {
        return movieWishList;
    }

    public void setMovieWishList(List<MovieWish> movieWishList) {
        this.movieWishList = movieWishList;
    }

    @Override
    public String toString() {
        return "BlueRayMovie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                ", blueRayMovieDetails=" + blueRayMovieDetails +
                '}';
    }
}
