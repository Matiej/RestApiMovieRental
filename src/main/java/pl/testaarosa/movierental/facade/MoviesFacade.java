package pl.testaarosa.movierental.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.dto.BlueRayMovieDto;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.mapper.BlueRayMovieMapper;
import pl.testaarosa.movierental.mapper.DvdMovieMapper;
import pl.testaarosa.movierental.mapper.OnLineMovieDetailsMapper;
import pl.testaarosa.movierental.mapper.OnLineMovieMapper;
import pl.testaarosa.movierental.services.BlueRayMovieService;
import pl.testaarosa.movierental.services.DvdMovieService;
import pl.testaarosa.movierental.services.OnLineMovieService;

import java.util.List;

@Service
public class MoviesFacade {
    @Autowired
    private BlueRayMovieService blueRayMovieService;
    @Autowired
    private BlueRayMovieMapper blueRayMovieMapper;
    @Autowired
    private BlueRayMovieMapper blueMovieDetailsMapper;
    @Autowired
    private DvdMovieService dvdMovieService;
    @Autowired
    private DvdMovieMapper dvdMovieMapper;
    @Autowired
    private OnLineMovieService onLineMovieService;
    @Autowired
    private OnLineMovieMapper mapper;
    @Autowired
    private OnLineMovieDetailsMapper detailsMapper;

    public List<BlueRayMovieDto> findAll() {
        return blueRayMovieMapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAll());
    }

    public List<BlueRayMovieDto> findAllContainsTitle(String title) {
        return blueRayMovieMapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAllContainsTitle(title));
    }

    public BlueRayMovieDto findbyId(Long id) {
        return blueMovieDetailsMapper.mapToBlueRayMovieDto(blueRayMovieService.findbyId(id));
    }

    public List<DvdMovieDto> findAllDvd() {
        return dvdMovieMapper.mapToDvdDtoList(dvdMovieService.findAll());
    }

    public DvdMovieDto findDvdById(Long id) {
        return dvdMovieMapper.mapToDvdMovieDto(dvdMovieService.findById(id));
    }

    public List<DvdMovieDto> findDvdByTitle(String title) {
        return dvdMovieMapper.mapToDvdDtoList(dvdMovieService.findByTitle(title));
    }

    public List<OnLineMovieDto> getOnLineMovies(String title) {
        return mapper.mapToOnLineMovieDtoList(onLineMovieService.getOnLineMovies(title));
    }

    public OnLineMovieDetailsDto getOnLineMovieDetails(String movieId) {
        return detailsMapper.mapToOnLineDetalisDto(onLineMovieService.getOnLineMovieDetails(movieId));
    }
}
