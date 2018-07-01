package pl.testaarosa.movierental.domain;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "UserMovie.findAllUsersMoviesForGivenUser", query = "FROM UserMovie WHERE user.id = :userId"),
})

@Entity
@Table(name = "USER_MOVIES")
public class UserMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_MOVIE_ID")
    private String imdbID;
    private String title;
    @Enumerated(value = EnumType.STRING)
    private UserMovieGenre genre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_DETAILS_ID")
    private UserMovieDetails userMovieDetails;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public UserMovie() {
    }

    private UserMovie(UserMovieBuilder userMovieBuilder) {
        this.imdbID = userMovieBuilder.imdbID;
        this.title = userMovieBuilder.title;
        this.genre = userMovieBuilder.genre;
        this.userMovieDetails = userMovieBuilder.userMovieDetails;
        this.user = userMovieBuilder.user;
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

    public User getUser() {
        return user;
    }

    public UserMovieDetails getUserMovieDetails() {
        return userMovieDetails;
    }

    public void setUserMovieDetails(UserMovieDetails userMovieDetails) {
        this.userMovieDetails = userMovieDetails;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static NeedImdbID builder() {
        return new UserMovieBuilder();
    }

    private static class UserMovieBuilder implements NeedImdbID, NeedTitle, NeedGenre, CanBuild {
        private String imdbID;
        private String title;
        private UserMovieGenre genre;
        private UserMovieDetails userMovieDetails;
        private User user;

        @Override
        public UserMovieBuilder imdbID(String imdbID){
            this.imdbID = imdbID;
            return this;
        }

        @Override
        public UserMovieBuilder title(String title){
            this.title = title;
            return this;
        }

        @Override
        public UserMovieBuilder genre(UserMovieGenre gener){
            this.genre = gener;
            return this;
        }

        @Override
        public UserMovieBuilder userMovieDetails(UserMovieDetails userMovieDetails){
            this.userMovieDetails = userMovieDetails;
            return this;
        }

        @Override
        public UserMovieBuilder user(User user) {
            this.user = user;
            return this;
        }

        @Override
        public UserMovie build(){
            return new UserMovie(this);
        }

        @Override
        public CanBuild and() {
            return this;
        }
    }

    public interface NeedImdbID {
        NeedTitle imdbID(String imdbID);
    }

    public interface NeedTitle {
        NeedGenre title(String title);
    }

    public interface NeedGenre{
        NeedGenre genre(UserMovieGenre genre);
        CanBuild and();
    }

    public interface CanBuild {
        CanBuild userMovieDetails(UserMovieDetails userMovieDetails);
        CanBuild user(User user);
        UserMovie build();

    }

}
