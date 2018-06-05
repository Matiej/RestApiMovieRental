package pl.testaarosa.movierental.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Movies_Wish_NEW")
public class MovieWish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_WISH_MOVIES",
            joinColumns = {@JoinColumn(name = "WISH_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "BLURAY_MOVIE_ID", referencedColumnName = "ID")})
    private List<BlueRayMovie> blueRayMovies = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_WISH_MOVIES",
            joinColumns = {@JoinColumn(name = "WISH_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ONLINE_MOVIE_ID", referencedColumnName = "ID")})
    private List<OnLineMovie> onLineMovies = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_WISH_MOVIES",
            joinColumns = {@JoinColumn(name = "WISH_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "DVD_MOVIE_ID", referencedColumnName = "ID")})
    private List<DvdMovie> dvdMovieList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BlueRayMovie> getBlueRayMovies() {
        return blueRayMovies;
    }

    public void setBlueRayMovies(List<BlueRayMovie> blueRayMovies) {
        this.blueRayMovies = blueRayMovies;
    }

    public List<OnLineMovie> getOnLineMovies() {
        return onLineMovies;
    }

    public void setOnLineMovies(List<OnLineMovie> onLineMovies) {
        this.onLineMovies = onLineMovies;
    }

    public List<DvdMovie> getDvdMovieList() {
        return dvdMovieList;
    }

    public void setDvdMovieList(List<DvdMovie> dvdMovieList) {
        this.dvdMovieList = dvdMovieList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
