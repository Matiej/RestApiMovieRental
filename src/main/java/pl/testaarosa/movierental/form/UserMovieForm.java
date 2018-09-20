package pl.testaarosa.movierental.form;

import pl.testaarosa.movierental.domain.UserMovieGenre;

import java.util.Objects;

public class UserMovieForm {

    private String imdbID;
    private String title;
    private String year;
    private String poster;
    private UserMovieGenre genre;
    private String runtime;
    private String userOpinion;
    private String actors;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMovieForm that = (UserMovieForm) o;
        return Objects.equals(imdbID, that.imdbID) &&
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
        return Objects.hash(imdbID, title, year, poster, genre, runtime, userOpinion, actors, plot);
    }

    @Override
    public String toString() {
        return "UserMovieForm{" +
                "imdbID='" + imdbID + '\'' +
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
