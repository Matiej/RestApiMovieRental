package pl.testaarosa.movierental.form.dto;

import pl.testaarosa.movierental.domain.UserMovieGenre;
//TODO walidacja
public class UserMovieFormDto {

    private Long id;
    private String imdbID;
    private String title;
    private String year;
    private String poster;
    private UserMovieGenre genre;
    private String runtime;
    private String userOpinion;
    private String actors;
    private String plot;

    public UserMovieFormDto() {
    }

    public UserMovieFormDto(Long id, String imdbID, String title, String year, String poster,
                            UserMovieGenre genre, String runtime, String userOpinion, String actors, String plot) {
        this.id = id;
        this.imdbID = imdbID;
        this.title = title;
        this.year = year;
        this.poster = poster;
        this.genre = genre;
        this.runtime = runtime;
        this.userOpinion = userOpinion;
        this.actors = actors;
        this.plot = plot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public UserMovieGenre getGenre() {
        return genre;
    }

    public void setGenre(UserMovieGenre genre) {
        this.genre = genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getUserOpinion() {
        return userOpinion;
    }

    public void setUserOpinion(String userOpinion) {
        this.userOpinion = userOpinion;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}

