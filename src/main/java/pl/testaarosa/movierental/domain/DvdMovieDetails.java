package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DVD_MOVIE_DETAILS")
public class DvdMovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imdbID;
    private String title;
    private String countryOfOrigin;
    private String type;
    private double price;
    private String poster;
    private String supplier;

    public DvdMovieDetails() {
    }

    public DvdMovieDetails(String imdbID, String title, String countryOfOrigin,
                           String type, double price, String poster, String supplier) {
        this.imdbID = imdbID;
        this.title = title;
        this.countryOfOrigin = countryOfOrigin;
        this.type = type;
        this.price = price;
        this.poster = poster;
        this.supplier = supplier;
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

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvdMovieDetails that = (DvdMovieDetails) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(imdbID, that.imdbID) &&
                Objects.equals(title, that.title) &&
                Objects.equals(countryOfOrigin, that.countryOfOrigin) &&
                Objects.equals(type, that.type) &&
                Objects.equals(poster, that.poster) &&
                Objects.equals(supplier, that.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imdbID, title, countryOfOrigin, type, price, poster, supplier);
    }

    @Override
    public String toString() {
        return "DvdMovieDetails{" +
                "id=" + id +
                ", imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", poster='" + poster + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}
