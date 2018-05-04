package pl.testaarosa.movierental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DVD_MOVIES")
public class DvdMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieId;
    private String title;
    private String countryOfOrigin;
    private String filmGenre;
    private double price;
    private String poster;

    @Override
    public String toString() {
        return "DvdMovie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", filmGenre='" + filmGenre + '\'' +
                ", price=" + price +
                '}';
    }
}
