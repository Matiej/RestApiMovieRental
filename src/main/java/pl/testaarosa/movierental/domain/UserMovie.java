package pl.testaarosa.movierental.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USER_MOVIES")
public class UserMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_MOVIE_SIGN")
    @Size(min = 2)
    @NotEmpty
    private String imdbID;
    @Size(min = 2)
    @NotEmpty
    private String title;
    @Size(min = 4, max = 4, message = "The year must entered it this way (1998)")
    @NotEmpty
    private String year;
    @Size(min = 2, max = 1000)
    private String poster;
    private String runtime;
    @Enumerated(value = EnumType.STRING)
    private UserMovieGenre genre;
    @Column(length = 1000)
    private String userOpinion;
    @Column(length = 1000)
    private String actors;
    @Column(name = "PLOT", length = 3000)
    private String plot;
}
