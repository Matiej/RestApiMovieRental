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
public class DvdMovie implements Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imdbID;
    private String title;
    private String countryOfOrigin;
    private String type;
    private double price;
    private String poster;
    private String supplier;

    @Override
    public String toString() {
        return "DvdMovie{" +
                "imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", filmGenre='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
