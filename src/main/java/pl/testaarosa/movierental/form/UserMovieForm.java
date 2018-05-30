package pl.testaarosa.movierental.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import pl.testaarosa.movierental.domain.UserMovieGenre;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMovieForm {
//TODO wyhwalic lomboka zobic pojo
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
    @Enumerated(value = EnumType.STRING)
    private UserMovieGenre genre;
    private String runtime;
    private String userOpinion;
    @Column(length = 1000)
    private String actors;
    @Column(name = "PLOT", length = 3000)
    private String plot;
}
