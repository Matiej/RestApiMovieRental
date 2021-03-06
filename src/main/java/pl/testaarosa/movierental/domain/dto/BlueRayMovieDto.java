package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.BlueRayMovieDetails;

import java.util.Objects;

public class BlueRayMovieDto {

    private Long id;
    private String title;
    private String imdbID;
    private String poster;
    private String supplier;
    private BlueRayMovieDetails blueRayMovieDetails;

    public BlueRayMovieDto() {
    }

    public BlueRayMovieDto(Long id, String title, String imdbID, String poster, String supplier, BlueRayMovieDetails blueRayMovieDetails) {
        this.id = id;
        this.title = title;
        this.imdbID = imdbID;
        this.poster = poster;
        this.supplier = supplier;
        this.blueRayMovieDetails = blueRayMovieDetails;
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

    public BlueRayMovieDetails getBlueRayMovieDetails() {
        return blueRayMovieDetails;
    }

    public void setBlueRayMovieDetails(BlueRayMovieDetails blueRayMovieDetails) {
        this.blueRayMovieDetails = blueRayMovieDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlueRayMovieDto that = (BlueRayMovieDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(imdbID, that.imdbID) &&
                Objects.equals(poster, that.poster) &&
                Objects.equals(supplier, that.supplier) &&
                Objects.equals(blueRayMovieDetails, that.blueRayMovieDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, imdbID, poster, supplier, blueRayMovieDetails);
    }

    @Override
    public String toString() {
        return "BlueRayMovieDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", poster='" + poster + '\'' +
                ", supplier='" + supplier + '\'' +
                ", blueRayMovieDetails=" + blueRayMovieDetails +
                '}';
    }
}
