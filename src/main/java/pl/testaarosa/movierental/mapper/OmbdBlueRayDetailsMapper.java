package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.BlueRayMovieDetails;
import pl.testaarosa.movierental.domain.dto.OmbdBlueRayDetailsDto;

@Component
public class OmbdBlueRayDetailsMapper {

    public BlueRayMovieDetails mapToBlueRayMovieDetails(final OmbdBlueRayDetailsDto mFSuppDetailsDto){

        return new BlueRayMovieDetails(
                mFSuppDetailsDto.getImdbID(),
                mFSuppDetailsDto.getTitle(),
                mFSuppDetailsDto.getYear(),
                mFSuppDetailsDto.getReleased(),
                mFSuppDetailsDto.getRuntime(),
                mFSuppDetailsDto.getGenre(),
                mFSuppDetailsDto.getWriter(),
                mFSuppDetailsDto.getActors(),
                mFSuppDetailsDto.getPlot(),
                mFSuppDetailsDto.getLanguage(),
                mFSuppDetailsDto.getCountry(),
                mFSuppDetailsDto.getAwards(),
                mFSuppDetailsDto.getPoster(),
                mFSuppDetailsDto.getProduction());

    }
}
