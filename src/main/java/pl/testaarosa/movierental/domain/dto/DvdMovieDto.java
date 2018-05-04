package pl.testaarosa.movierental.domain.dto;

import lombok.Getter;

import java.util.Optional;

@Getter
public class DvdMovieDto {
    private final String movieId;
    private final String title;
    private final String countryOfOrigin;
    private final String filmGenre;
    private double price;

    private DvdMovieDto(final String movieId, final String title, final String countryOfOrigin,
                        final String filmGenre, final double price) {
        this.movieId = movieId;
        this.title = title;
        this.countryOfOrigin = countryOfOrigin;
        this.filmGenre = filmGenre;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Builder{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", filmGenre='" + filmGenre + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private String movieId;
        private String title;
        private String countryOfOrigin;
        private String filmGenre;
        private double price;

        public Builder movieId(String movieId) {
            this.movieId = movieId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder countryOfOrigin(String countryOfOrigin) {
            this.countryOfOrigin = countryOfOrigin;
            return this;
        }

        public Builder filmGenre(String filmGenre) {
            this.filmGenre = filmGenre;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public DvdMovieDto build() {
            movieId = Optional.ofNullable(movieId).orElse("no data");
            title = Optional.ofNullable(title).orElse("no data");
            countryOfOrigin = Optional.ofNullable(countryOfOrigin).orElse("no data");
            filmGenre = Optional.ofNullable(filmGenre).orElse("no data");
            price = Optional.ofNullable(price).orElse(Double.valueOf("0.0"));
            return new DvdMovieDto(movieId, title, countryOfOrigin, filmGenre, price);
        }
    }
}
