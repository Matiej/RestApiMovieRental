package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.MovieWish;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class MovieDto {

    private Long id;
    private String title;
    private String imdbID;
    private String poster;
    private String supplier;
    private List<MovieWish> movieWishList = new ArrayList<>();

    public MovieDto(Long id, String title, String imdbID, String poster, String supplier, List<MovieWish> movieWishList) {
        this.id = id;
        this.title = title;
        this.imdbID = imdbID;
        this.poster = poster;
        this.supplier = supplier;
        this.movieWishList = movieWishList;
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
}
