package pl.testaarosa.movierental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BLUE_RAY_DETAILS")
public class BlueRayMovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imdbID;
    private String title;
    private String year;
    private String released;
    private String runtime;
    private String genre;
    @Column(length = 1000)
    private String writer;
    @Column(length = 1000)
    private String actors;
    @Column(name = "PLOT", length = 3000)
    private String plot;
    private String language;
    private String country;
    private String awards;
    @Column(length = 1000)
    private String poster;
    @Column(length = 1000)
    private String production;

    @Override
    public String toString() {
        return "BlueRayMovieDetails{" +
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
                ", production='" + production + '\'' +
                                '}';
    }
}
