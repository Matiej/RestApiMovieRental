package pl.testaarosa.movierental.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.mapper.DvdMovieMapper;
import pl.testaarosa.movierental.services.DvdMovieService;

import java.util.List;

@Service
public class DvdMoviesFacade {

    @Autowired
    private DvdMovieService dvdMovieService;
    @Autowired
    private DvdMovieMapper dvdMovieMapper;

    public List<DvdMovieDto> findAll() {
        return dvdMovieMapper.mapToDvdDtoList(dvdMovieService.findAll());
    }

    public DvdMovieDto findById(Long id) {
        return dvdMovieMapper.mapToDvdMovieDto(dvdMovieService.findById(id));
    }

    public List<DvdMovieDto> findByTitle(String title) {
        return dvdMovieMapper.mapToDvdDtoList(dvdMovieService.findByTitle(title));
    }



}
