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
import java.util.concurrent.ExecutionException;

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
    private OnLineMovieMapper onLineMovieMapper;
    @Autowired
    private OnLineMovieDetailsMapper detailsMapper;

    public List<BlueRayMovieDto> findAllBlueRay() {
        return blueRayMovieMapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAll());
    }

    public List<BlueRayMovieDto> findAllBlueRayContainsTitle(String title) {
        return blueRayMovieMapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAllContainsTitle(title));
    }

    public BlueRayMovieDto findBlueRaById(Long id) {
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

    public List<OnLineMovieDto> getOnLineMovies(String title) throws ExecutionException, InterruptedException {
        return onLineMovieMapper.mapToOnLineMovieDtoList(onLineMovieService.getOnLineMovies(title));
    }

    public OnLineMovieDetailsDto getOnLineMovieDetails(String movieId) throws ExecutionException, InterruptedException {
        return detailsMapper.mapToOnLineDetalisDto(onLineMovieService.getOnLineMovieDetails(movieId));
    }

    public OnLineMovieDto findOnLineById(Long id) {
        return onLineMovieMapper.mapToOnlineMovieDto(onLineMovieService.findById(id));
    }

    public OnLineMovieDto addOnLineMovieToDb(String imdbID) throws ExecutionException, InterruptedException {
        return onLineMovieMapper.mapToOnlineMovieDto(onLineMovieService.addOnLineMovieToDb(imdbID));
    }
}
