package pl.testaarosa.movierental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "WISH_LIST")
public class MoviesWishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String supId;
    private String title;
    private String filmGenre;
    private String poster;
    private String supplier;

    @Override
    public String toString() {
        return "MoviesWishList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", filmGenre='" + filmGenre + '\'' +
                ", poster='" + poster + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}
