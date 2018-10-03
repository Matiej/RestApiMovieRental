package pl.testaarosa.movierental.domain.dto;

import java.util.Objects;
import java.util.Optional;
public class OneDvdDto {
    private final String movieId;
    private final String title;
    private final String countryOfOrigin;
    private final String filmGenre;
    private double price;

    private OneDvdDto(final String movieId, final String title, final String countryOfOrigin,
                      final String filmGenre, final double price) {
        this.movieId = movieId;
        this.title = title;
        this.countryOfOrigin = countryOfOrigin;
        this.filmGenre = filmGenre;
        this.price = price;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "imdbID='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", filmGenre='" + filmGenre + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneDvdDto oneDvdDto = (OneDvdDto) o;
        return Double.compare(oneDvdDto.price, price) == 0 &&
                Objects.equals(movieId, oneDvdDto.movieId) &&
                Objects.equals(title, oneDvdDto.title) &&
                Objects.equals(countryOfOrigin, oneDvdDto.countryOfOrigin) &&
                Objects.equals(filmGenre, oneDvdDto.filmGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, title, countryOfOrigin, filmGenre, price);
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

        public OneDvdDto build() {
            movieId = Optional.ofNullable(movieId).orElse("no data");
            title = Optional.ofNullable(title).orElse("no data");
            countryOfOrigin = Optional.ofNullable(countryOfOrigin).orElse("no data");
            filmGenre = Optional.ofNullable(filmGenre).orElse("no data");
            price = Optional.ofNullable(price).orElse(Double.valueOf("0.0"));
            return new OneDvdDto(movieId, title, countryOfOrigin, filmGenre, price);
        }
    }
}
