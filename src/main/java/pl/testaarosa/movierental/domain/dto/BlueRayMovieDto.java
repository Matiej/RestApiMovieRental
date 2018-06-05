package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.BlueRayMovieDetails;

public class BlueRayMovieDto {

    private Long id;
    private String title;
    private String year;
    private String imdbID;
    private String type;
    private String poster;
    private String supplier;
    private BlueRayMovieDetails blueRayMovieDetails;

    public BlueRayMovieDto() {
    }

    public BlueRayMovieDto(Long id, String title, String year, String imdbID, String type, String poster,
                           String supplier, BlueRayMovieDetails blueRayMovieDetails) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}