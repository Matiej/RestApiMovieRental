package pl.testaarosa.movierental.domain;

import javax.persistence.*;

@Entity
@Table(name = "MOVIES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
//    private String year;
    private String imdbID;
//    private String type;
    private String poster;
    private String supplier;

    public Movie() {
    }

    public Movie(String title, String imdbID, String poster, String supplier) {
        this.title = title;
        this.imdbID = imdbID;
        this.poster = poster;
        this.supplier = supplier;
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

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

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
}
