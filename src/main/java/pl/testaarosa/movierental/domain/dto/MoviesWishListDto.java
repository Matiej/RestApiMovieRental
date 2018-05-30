package pl.testaarosa.movierental.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//TODO wywalić klase cała, przerobić na MoiviesWish. Będzie do kontrolera ewentualnie
public class MoviesWishListDto {
    private Long id;
    private String supId;
    private String title;
    private String filmGenre;
    private String poster;
    private String supplier;
}
