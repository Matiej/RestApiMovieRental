package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("BLUE_RAY_MOVIES")
public class BlueRayMovie extends Movie{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BLUE_DET_ID")
    private BlueRayMovieDetails blueRayMovieDetails;

    public BlueRayMovie() {
    }

   public BlueRayMovie(String title, String imdbID, String poster, String supplier){
        super(title,imdbID,poster,supplier);
   }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public String getImdbID() {
        return super.getImdbID();
    }

    @Override
    public void setImdbID(String imdbID) {
        super.setImdbID(imdbID);
    }

    @Override
    public String getPoster() {
        return super.getPoster();
    }

    @Override
    public void setPoster(String poster) {
        super.setPoster(poster);
    }

    @Override
    public String getSupplier() {
        return super.getSupplier();
    }

    @Override
    public void setSupplier(String supplier) {
        super.setSupplier(supplier);
    }

    public BlueRayMovieDetails getBlueRayMovieDetails() {
        return blueRayMovieDetails;
    }

    public void setBlueRayMovieDetails(BlueRayMovieDetails blueRayMovieDetails) {
        this.blueRayMovieDetails = blueRayMovieDetails;
    }

    @Override
    public String toString() {
        return "BlueRayMovie{" +
                "blueRayMovieDetails=" + blueRayMovieDetails +
                '}';
    }
}

