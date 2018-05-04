package pl.testaarosa.movierental.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.testaarosa.movierental.domain.UserMovieGenre;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMovieDto {
    private Long id;
    private String imdbID;
    private String title;
    private String year;
    private String poster;
    private String runtime;
    private UserMovieGenre genre;
    private String userOpinion;
    private String actors;
    private String plot;
}
