package pl.testaarosa.movierental.domain.dto;

import pl.testaarosa.movierental.domain.OnLineMovieDetails;

public class OnLineMovieDto {

    private Long id;
    private String title;
    private String year;
    private String imdbID;
//    private String type;
    private String poster;
    private String supplier;
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
}
