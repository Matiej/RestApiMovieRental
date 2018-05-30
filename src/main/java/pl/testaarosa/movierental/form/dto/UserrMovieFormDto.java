package pl.testaarosa.movierental.form.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.testaarosa.movierental.domain.UserMovieGenre;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserrMovieFormDto {
//TODO wywalić lomboka zrobić pojo
    private Long id;
    private String imdbID;
    private String title;
    private String year;
    private String poster;
    private UserMovieGenre genre;
    private String runtime;
    private String userOpinion;
    private String actors;
    private String plot;
}

