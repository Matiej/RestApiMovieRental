package pl.testaarosa.movierental.form;

import org.hibernate.validator.constraints.NotEmpty;
import pl.testaarosa.movierental.domain.UserMovieGenre;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

public class UserMovieForm {

    @Size(min = 2)
    @NotEmpty
    private String imdbID;
    @Size(min = 2)
    @NotEmpty
    private String title;
    @Size(min = 4, max = 4, message = "The year must entered it this way (1998)")
    @NotEmpty
    private String year;
    @Size(min = 2, max = 1000)
    private String poster;
    @Enumerated(value = EnumType.STRING)
    private UserMovieGenre genre;
    private String runtime;
    private String userOpinion;
    @Column(length = 1000)
    private String actors;
    @Column(name = "PLOT", length = 3000)
    private String plot;

    public UserMovieForm(String imdbID, String title, String year, String poster, UserMovieGenre genre,
                         String runtime, String userOpinion, String actors, String plot) {
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
