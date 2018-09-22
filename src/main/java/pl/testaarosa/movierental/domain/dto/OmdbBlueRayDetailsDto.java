package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbBlueRayDetailsDto {
    @JsonProperty("imdbID")
    private String imdbID;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Released")
    private String released;
    @JsonProperty("Runtime")
    private String runtime;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Writer")
    private String writer;
    @JsonProperty("Actors")
    private String actors;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Awards")
    private String awards;
    @JsonProperty("Poster")
    private String poster;
    @JsonProperty("Production")
    private String production;

    public OmdbBlueRayDetailsDto() {
    }

    public OmdbBlueRayDetailsDto(String imdbID, String title, String year, String released, String runtime,
                                 String genre, String writer, String actors, String plot, String language,
                                 String country, String awards, String poster, String production) {
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

    public String getImdbID() {
        return imdbID;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public String getProduction() {
        return production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmdbBlueRayDetailsDto that = (OmdbBlueRayDetailsDto) o;
        return Objects.equals(imdbID, that.imdbID) &&
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
        return Objects.hash(imdbID, title, year, released, runtime, genre, writer, actors, plot, language, country, awards, poster, production);
    }

    @Override
    public String toString() {
        return "OmdbBlueRayDetailsDto{" +
                "imdbID='" + imdbID + '\'' +
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
