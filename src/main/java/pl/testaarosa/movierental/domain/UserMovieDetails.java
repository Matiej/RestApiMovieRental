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

    public static class UserMovieDetailsBuilder{
        private Long id;
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

        public UserMovieDetailsBuilder actors(String actors){
            this.actors = actors;
            return this;
        }

        public UserMovieDetailsBuilder plot(String plot){
            this.plot = plot;
            return this;
        }

        public UserMovieDetailsBuilder userMovie(UserMovie userMovie){
            this.userMovie = userMovie;
            return this;
        }

        public UserMovieDetails build(){
            return new UserMovieDetails(this);
        }
    }
}
