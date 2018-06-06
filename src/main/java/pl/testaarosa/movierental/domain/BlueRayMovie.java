package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("BLUE_RAY_MOVIES")
public class BlueRayMovie extends Movie{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String title;
    private String imdbID;
    private String poster;
    private String supplier;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DETAILS_ID")
    private BlueRayMovieDetails blueRayMovieDetails;

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "blueRayMovies", targetEntity = MovieWish.class)
//    private List<MovieWish> movieWishList = new ArrayList<>();

    public BlueRayMovie() {
    }

   public BlueRayMovie(String title, String imdbID, String poster, String supplier){
        this.title = title;
        this.imdbID = imdbID;
        this.poster = poster;
        this.supplier = supplier;
   }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getImdbID() {
        return imdbID;
    }

    @Override
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    public String getPoster() {
        return poster;
    }

    @Override
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String getSupplier() {
        return supplier;
    }

    @Override
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public BlueRayMovieDetails getBlueRayMovieDetails() {
        return blueRayMovieDetails;
    }

    public void setBlueRayMovieDetails(BlueRayMovieDetails blueRayMovieDetails) {
        this.blueRayMovieDetails = blueRayMovieDetails;
    }

//    public List<MovieWish> getMovieWishList() {
//        return movieWishList;
//    }
//
//    public void setMovieWishList(List<MovieWish> movieWishList) {
//        this.movieWishList = movieWishList;
//    }

    @Override
    public String toString() {
        return "BlueRayMovie{" +
                "title='" + title + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", poster='" + poster + '\'' +
                ", supplier='" + supplier + '\'' +
                ", blueRayMovieDetails=" + blueRayMovieDetails +

                '}';
    }
}
