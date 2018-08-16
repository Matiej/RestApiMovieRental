package pl.testaarosa.movierental.domain;

import javax.persistence.*;

@Entity
public class UserMovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year;
    private String poster;
    private String runtime;
    @Column(length = 1000)
    private String userOpinion;
    @Column(length = 1000)
    private String actors;
    @Column(length = 3000)
    private String plot;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_MOVIE_ID")
    private UserMovie userMovie;

    public UserMovieDetails() {
    }

    private UserMovieDetails(UserMovieDetailsBuilder userMovieDetailsBuilder) {
        this.year = userMovieDetailsBuilder.year;
        this.poster = userMovieDetailsBuilder.poster;
        this.runtime = userMovieDetailsBuilder.runtime;
        this.userOpinion = userMovieDetailsBuilder.userOpinion;
        this.actors = userMovieDetailsBuilder.actors;
        this.plot = userMovieDetailsBuilder.plot;
        this.userMovie = userMovieDetailsBuilder.userMovie;
    }

    public void setUserMovie(UserMovie userMovie) {
        this.userMovie = userMovie;
    }

    public Long getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getUserOpinion() {
        return userOpinion;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public UserMovie getUserMovie() {
        return userMovie;
    }

    public static NeedYear builder() {
        return new UserMovieDetailsBuilder();
    }

    private static class UserMovieDetailsBuilder implements NeedYear, NeedPoster, NeedRuntime, NeedUserOpinion, NeedActors, NeedPlot, CanBeBuild{
        private String year;
        private String poster;
        private String runtime;
        private String userOpinion;
        private String actors;
        private String plot;
        private UserMovie userMovie;

        public UserMovieDetailsBuilder year(String year){
            this.year = year;
            return this;
        }

        public UserMovieDetailsBuilder poster(String poster){
            this.poster = poster;
            return this;
        }

        public UserMovieDetailsBuilder runtime(String runtime){
            this.runtime = runtime;
            return this;
        }

        public UserMovieDetailsBuilder userOpinion(String userOpinion){
            this.userOpinion = userOpinion;
            return this;
        }

        @Override
        public UserMovieDetailsBuilder actors(String actors){
            this.actors = actors;
            return this;
        }

        @Override
        public UserMovieDetailsBuilder plot(String plot){
            this.plot = plot;
            return this;
        }

        @Override
        public UserMovieDetailsBuilder userMovie(UserMovie userMovie){
            this.userMovie = userMovie;
            return this;
        }

        @Override
        public UserMovieDetails build(){
            return new UserMovieDetails(this);
        }
    }

    public interface NeedYear {
        public NeedPoster year(String year);
    }

    public interface NeedPoster {
        NeedRuntime poster(String poster);
    }

    public interface NeedRuntime {
        NeedUserOpinion runtime(String runtime);
    }

    public interface NeedUserOpinion {
        NeedActors userOpinion(String userOpinion);
    }

    public interface NeedActors {
        NeedPlot actors(String actors);
    }

    public interface NeedPlot {
        CanBeBuild plot(String plot);
    }

    public interface CanBeBuild {
        CanBeBuild userMovie(UserMovie userMovie);
        UserMovieDetails build();
    }
}
