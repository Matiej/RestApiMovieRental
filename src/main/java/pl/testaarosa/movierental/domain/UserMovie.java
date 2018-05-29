package pl.testaarosa.movierental.domain;

import javax.persistence.*;

@Entity
@Table(name = "USER_MOVIES")
public class UserMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_MOVIE_SIGN")
    private String imdbID;
    private String title;
    @Enumerated(value = EnumType.STRING)
    private UserMovieGenre genre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_DETAILS_ID")
    private UserMovieDetails userMovieDetails;

    public UserMovie() {
    }

    private UserMovie(UserMovieBuilder userMovieBuilder) {
        this.imdbID = userMovieBuilder.imdbID;
        this.title = userMovieBuilder.title;
        this.genre = userMovieBuilder.genre;
        this.userMovieDetails = userMovieBuilder.userMovieDetails;

    }

    public Long getId() {
        return id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getTitle() {
        return title;
    }

    public UserMovieGenre getGenre() {
        return genre;
    }

    public UserMovieDetails getUserMovieDetails() {
        return userMovieDetails;
    }
    public void setUserMovieDetails(UserMovieDetails userMovieDetails) {
        this.userMovieDetails = userMovieDetails;
    }

    public static class UserMovieBuilder {
        private Long id;
        private String imdbID;
        private String title;
        private UserMovieGenre genre;
        private UserMovieDetails userMovieDetails;



        public UserMovieBuilder imdbID(String imdbID){
            this.imdbID = imdbID;
            return this;
        }

        public UserMovieBuilder title(String title){
            this.title = title;
            return this;
        }

        public UserMovieBuilder genre(UserMovieGenre gener){
            this.genre = gener;
            return this;
        }

        public UserMovieBuilder userMovieDetails(UserMovieDetails userMovieDetails){
            this.userMovieDetails = userMovieDetails;
            return this;
        }

        public UserMovie build(){
            return new UserMovie(this);
        }
    }
}
