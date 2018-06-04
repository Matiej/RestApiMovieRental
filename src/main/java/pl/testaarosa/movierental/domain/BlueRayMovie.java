package pl.testaarosa.movierental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BLUE_RAY_MOVIES")
public class BlueRayMovie implements Movies{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String year;
    private String imdbID;
    private String type;
    private String poster;
    private String supplier;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DETAILS_ID")
    private BlueRayMovieDetails blueRayMovieDetails;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "blueRayMovies", targetEntity = MovieWish.class)
    private List<MovieWish> movieWishList = new ArrayList<>();


    @Override
    public String toString() {
        return "BlueRayMovie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                ", blueRayMovieDetails=" + blueRayMovieDetails +
                '}';
    }
}
