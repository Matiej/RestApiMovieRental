package pl.testaarosa.movierental.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.OnLineMovie;
import pl.testaarosa.movierental.domain.dto.*;
import pl.testaarosa.movierental.mapper.*;
import pl.testaarosa.movierental.services.BlueRayMovieService;
import pl.testaarosa.movierental.services.DvdMovieService;
import pl.testaarosa.movierental.services.MovieService;
import pl.testaarosa.movierental.services.OnLineMovieService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MoviesFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoviesFacade.class);
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
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieMapper movieMapper;

    public List<BlueRayMovieDto> findAllBlueRay() {
        return blueRayMovieMapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAll());
    }

    public List<BlueRayMovieDto> findAllBlueRayContainsTitle(String title) {
        return blueRayMovieMapper.mapToBlueRayMovieDtoList(blueRayMovieService.findAllContainsTitle(title));
    }

    public BlueRayMovieDto findBlueRaById(Long id) throws MovieNotFoundException {
        return blueMovieDetailsMapper.mapToBlueRayMovieDto(blueRayMovieService.findbyId(id));
    }

    public List<DvdMovieDto> findAllDvd() {
        return dvdMovieMapper.mapToDvdDtoList(dvdMovieService.findAll());
    }

    public DvdMovieDto findDvdById(Long id) throws MovieNotFoundException {
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

    public OnLineMovieDto findOnLineById(Long id) throws MovieNotFoundException {
        return onLineMovieMapper.mapToOnlineMovieDto(onLineMovieService.findById(id));
    }

    public OnLineMovieDto addOnLineMovieToDb(String imdbID) throws ExecutionException, InterruptedException, MovieNotFoundException {
        OnLineMovie onLineMovie = onLineMovieService.addOnLineMovieToDb(imdbID);
        return onLineMovieMapper.mapToOnlineMovieDto(onLineMovie);
    }

    public MovieDto findMovieById(Long id) throws MovieNotFoundException {
        return movieMapper.mapToMovieDto(movieService.findById(id));
    }
}
