package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDetailsDto;

@Component
public class BlueRayMovieDetailsMapper {

    public BlueRayMovieDetails mapToMovieFromSupplierTwoDetails(final BlueRayMovieDetailsDto mFSuppDetailsDto){
        return BlueRayMovieDetails.builder()
                .imdbID(mFSuppDetailsDto.getImdbID())
                .title(mFSuppDetailsDto.getTitle())
                .year(mFSuppDetailsDto.getYear())
                .released(mFSuppDetailsDto.getReleased())
                .runtime(mFSuppDetailsDto.getRuntime())
                .genre(mFSuppDetailsDto.getGenre())
                .writer(mFSuppDetailsDto.getWriter())
                .actors(mFSuppDetailsDto.getActors())
                .plot(mFSuppDetailsDto.getPlot())
                .language(mFSuppDetailsDto.getLanguage())
                .country(mFSuppDetailsDto.getCountry())
                .awards(mFSuppDetailsDto.getAwards())
                .poster(mFSuppDetailsDto.getPoster())
                .production(mFSuppDetailsDto.getProduction())
                .build();
    }
}
