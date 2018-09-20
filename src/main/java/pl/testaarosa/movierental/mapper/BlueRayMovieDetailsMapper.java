//package pl.testaarosa.movierental.mapper;
//
//import org.springframework.stereotype.Component;
//import pl.testaarosa.movierental.domain.BlueRayMovieDetails;
//import pl.testaarosa.movierental.domain.dto.BlueRayMovieDetailsDto;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class BlueRayMovieDetailsMapper {
//
//    public BlueRayMovieDetailsDto mapToBRMovieDetailsDto(BlueRayMovieDetails blueDetails) {
//        return new BlueRayMovieDetailsDto(
//                blueDetails.getId(),
//                blueDetails.getImdbID(),
//                blueDetails.getTitle(),
//                blueDetails.getYear(),
//                blueDetails.getReleased(),
//                blueDetails.getRuntime(),
//                blueDetails.getGenre(),
//                blueDetails.getWriter(),
//                blueDetails.getActors(),
//                blueDetails.getPlot(),
//                blueDetails.getLanguage(),
//                blueDetails.getCountry(),
//                blueDetails.getAwards(),
//                blueDetails.getPoster(),
//                blueDetails.getProduction());
//    }
//
//    public List<BlueRayMovieDetailsDto> mapToBRMovieDetailsDtoList(List<BlueRayMovieDetails> detailsList) {
//        return detailsList.stream()
//                .map(b-> new BlueRayMovieDetailsDto(
//                        b.getId(),
//                        b.getImdbID(),
//                        b.getTitle(),
//                        b.getYear(),
//                        b.getReleased(),
//                        b.getRuntime(),
//                        b.getGenre(),
//                        b.getWriter(),
//                        b.getActors(),
//                        b.getPlot(),
//                        b.getLanguage(),
//                        b.getCountry(),
//                        b.getAwards(),
//                        b.getPoster(),
//                        b.getProduction()))
//                .collect(Collectors.toList());
//    }
//}
