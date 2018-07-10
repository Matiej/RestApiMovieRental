package pl.testaarosa.movierental.mapper;

import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.OneDvdDto;

@Component
public class OneDvdMapper {

    public DvdMovie mapToDvdMovie(OneDvdDto oneDvdDto) {
        return new DvdMovie(
                oneDvdDto.getTitle(),
                oneDvdDto.getMovieId(),
                "http://goshico.com/allegro/questionmarksmall.png",
                "DVD MOVIE");
    }
}
