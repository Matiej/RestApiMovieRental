package pl.testaarosa.movierental.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Movies_Wish_NEW")
public class MovieWish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String wishName;
    @Column(name = "WISH_DESCRIPTION", length = 1000)
    private String wishDesc;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_WISH_MOVIE",
    joinColumns = {@JoinColumn(name = "WISH_ID", referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name = "MOVIES_ID", referencedColumnName = "ID")})
    private List<Movie> moviesList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    public String getWishDesc() {
        return wishDesc;
    }

    public void setWishDesc(String wishDesc) {
        this.wishDesc = wishDesc;
    }
}
