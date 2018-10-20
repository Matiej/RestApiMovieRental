package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class OnLineMovieDetailsDto {

    @JsonIgnore
    private Long id;
    private String imdbID;
    private String title;
    private String year;
    private String released;
    private String runtime;
    private String genre;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    private String production;

    public OnLineMovieDetailsDto(Long id, String imdbID, String title, String year, String released,
                                 String runtime, String genre, String writer, String actors, String plot,
                                 String language, String country, String awards, String poster, String production) {
        this.id = id;
        this.imdbID = imdbID;
        this.title = title;
        this.year = year;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.production = production;
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

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnLineMovieDetailsDto that = (OnLineMovieDetailsDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(imdbID, that.imdbID) &&
                Objects.equals(title, that.title) &&
                Objects.equals(year, that.year) &&
                Objects.equals(released, that.released) &&
                Objects.equals(runtime, that.runtime) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(writer, that.writer) &&
                Objects.equals(actors, that.actors) &&
                Objects.equals(plot, that.plot) &&
                Objects.equals(language, that.language) &&
                Objects.equals(country, that.country) &&
                Objects.equals(awards, that.awards) &&
                Objects.equals(poster, that.poster) &&
                Objects.equals(production, that.production);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imdbID, title, year, released, runtime, genre, writer, actors, plot, language, country, awards, poster, production);
    }

    @Override
    public String toString() {
        return "OnLineMovieDetailsDto{" +
                "id=" + id +
                ", imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", released='" + released + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                ", production='" + production + '\'' +
                '}';
    }
}
