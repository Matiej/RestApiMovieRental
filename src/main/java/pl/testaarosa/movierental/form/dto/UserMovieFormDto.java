package pl.testaarosa.movierental.form.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import pl.testaarosa.movierental.domain.UserMovieGenre;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserMovieFormDto {

    private Long id;
    @NotEmpty
    private String imdbID;
    @Size(min = 2, message = "Title size must be longer than 2")
    private String title;
    @Size(min = 4, max = 4, message = "The year must entered it this way (1998)")
    private String year;
    @Size(min = 2, max = 1000)
    private String poster;
    @Enumerated(value = EnumType.STRING)
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

    @JsonIgnore
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMovieFormDto that = (UserMovieFormDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(imdbID, that.imdbID) &&
                Objects.equals(title, that.title) &&
                Objects.equals(year, that.year) &&
                Objects.equals(poster, that.poster) &&
                genre == that.genre &&
                Objects.equals(runtime, that.runtime) &&
                Objects.equals(userOpinion, that.userOpinion) &&
                Objects.equals(actors, that.actors) &&
                Objects.equals(plot, that.plot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imdbID, title, year, poster, genre, runtime, userOpinion, actors, plot);
    }

    @Override
    public String toString() {
        return "UserMovieFormDto{" +
                "id=" + id +
                ", imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", poster='" + poster + '\'' +
                ", genre=" + genre +
                ", runtime='" + runtime + '\'' +
                ", userOpinion='" + userOpinion + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}

