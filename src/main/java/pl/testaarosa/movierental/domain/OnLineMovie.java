package pl.testaarosa.movierental.domain;

import javax.persistence.*;

@Entity
@Table(name = "ONLINE_MOVIES")
public class OnLineMovie implements Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String year;
    private String imdbID;
    private String type;
    private String poster;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DETAILS_ID")
    private OnLineMovieDetails onLineMovieDetails;

    public OnLineMovie() {
    }

    public OnLineMovie(String title, String year, String imdbID, String type, String poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
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

    public OnLineMovieDetails getOnLineMovieDetails() {
        return onLineMovieDetails;
    }

    public void setOnLineMovieDetails(OnLineMovieDetails onLineMovieDetails) {
        this.onLineMovieDetails = onLineMovieDetails;
    }

    @Override
    public String toString() {
        return "BlueRayMovie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                ", onLineMovieDetails=" + onLineMovieDetails +
                '}';
    }
}
