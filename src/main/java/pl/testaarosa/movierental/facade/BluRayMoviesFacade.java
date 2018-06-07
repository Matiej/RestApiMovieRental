package pl.testaarosa.movierental.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.mapper.BlueRayMovieMapper;
import pl.testaarosa.movierental.services.BlueRayMovieService;

import java.util.List;

@Service
public class BluRayMoviesFacade {
    @Autowired
    private BlueRayMovieService blueRayMovieService;
    @Autowired
    private BlueRayMovieMapper blueRayMovieMapper;
    @Autowired
    private BlueRayMovieMapper blueMovieDetailsMapper;


    public List<BlueRayMovieDto> findAll() {
        return blueRayMovieMapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAll());
    }

    public List<BlueRayMovieDto> findAllContainsTitle(String title) {
        return blueRayMovieMapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAllContainsTitle(title));
    }

    public BlueRayMovieDto findbyId(Long id) {
        return blueMovieDetailsMapper.mapToBlueRayMovieDto(blueRayMovieService.findbyId(id));
    }



}
