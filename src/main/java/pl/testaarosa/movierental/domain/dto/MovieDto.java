package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.MovieWish;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(id, movieDto.id) &&
                Objects.equals(title, movieDto.title) &&
                Objects.equals(imdbID, movieDto.imdbID) &&
                Objects.equals(poster, movieDto.poster) &&
                Objects.equals(supplier, movieDto.supplier) &&
                Objects.equals(movieWishList, movieDto.movieWishList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, imdbID, poster, supplier, movieWishList);
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", poster='" + poster + '\'' +
                ", supplier='" + supplier + '\'' +
                ", movieWishList=" + movieWishList +
                '}';
    }
}
