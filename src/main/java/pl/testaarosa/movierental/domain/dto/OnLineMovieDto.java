package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.testaarosa.movierental.domain.OnLineMovieDetails;

import java.util.Objects;

public class OnLineMovieDto {

    private Long id;
    private String year;
    private String title;
    private String imdbID;
    private String poster;
    private String supplier;
//    @JsonIgnore
    private OnLineMovieDetails onLineMovieDetails;

    public OnLineMovieDto(Long id, String year, String title, String imdbID, String poster,
                          String supplier, OnLineMovieDetails onLineMovieDetails) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.poster = poster;
        this.supplier = supplier;
        this.onLineMovieDetails = onLineMovieDetails;
    }

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

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

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

//    public String getType() {
//        return type;
//    }

//    public void setType(String type) {
//        this.type = type;
//    }

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

    public OnLineMovieDetails getOnLineMovieDetails() {
        return onLineMovieDetails;
    }

    public void setOnLineMovieDetails(OnLineMovieDetails onLineMovieDetails) {
        this.onLineMovieDetails = onLineMovieDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnLineMovieDto that = (OnLineMovieDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(year, that.year) &&
                Objects.equals(imdbID, that.imdbID) &&
                Objects.equals(poster, that.poster) &&
                Objects.equals(supplier, that.supplier) &&
                Objects.equals(onLineMovieDetails, that.onLineMovieDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, imdbID, poster, supplier, onLineMovieDetails);
    }

    @Override
    public String toString() {
        return "OnLineMovieDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", poster='" + poster + '\'' +
                ", supplier='" + supplier + '\'' +
                ", onLineMovieDetails=" + onLineMovieDetails +
                '}';
    }
}
