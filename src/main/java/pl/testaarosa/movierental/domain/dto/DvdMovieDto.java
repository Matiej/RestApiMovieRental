package pl.testaarosa.movierental.domain.dto;

import java.util.Optional;

public class DvdMovieDto {

    private final Long id;
    private final String imdbID;
    private final String title;
    private final String countryOfOrigin;
    private final String type;
    private double price;
    private final String poster;
    private final String supplier;

    private DvdMovieDto(final Long id, final String imdbID, final String title, final String countryOfOrigin,
                        final String type, final double price, String poster, String supplier) {
        this.id = id;
        this.imdbID = imdbID;
        this.title = title;
        this.countryOfOrigin = countryOfOrigin;
        this.type = type;
        this.price = price;
        this.poster = poster;
        this.supplier = supplier;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getTitle() {
        return title;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public String getPoster() {
        return poster;
    }

    public String getSupplier() {
        return supplier;
    }

    public static class Builder {
        private Long id;
        private String imdbID;
        private String title;
        private String countryOfOrigin;
        private String type;
        private double price;
        private String poster;
        private String supplier;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder imdbID(String movieId) {
            this.imdbID = movieId;
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

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder poster(String poster) {
            this.poster = poster;
            return this;
        }

        public Builder supplier(String supplier) {
            this.supplier = supplier;
            return this;
        }

        public DvdMovieDto build() {
            id = Optional.ofNullable(id).orElse(999L);
            imdbID = Optional.ofNullable(imdbID).orElse("no data");
            title = Optional.ofNullable(title).orElse("no data");
            countryOfOrigin = Optional.ofNullable(countryOfOrigin).orElse("no data");
            type = Optional.ofNullable(type).orElse("no data");
            price = Optional.ofNullable(price).orElse(Double.valueOf("0.0"));
            poster = Optional.ofNullable(poster).orElse("no data");
            supplier = Optional.ofNullable(supplier).orElse("no data");
            return new DvdMovieDto(id, imdbID, title, countryOfOrigin, type, price, poster, supplier);
        }
    }
}
