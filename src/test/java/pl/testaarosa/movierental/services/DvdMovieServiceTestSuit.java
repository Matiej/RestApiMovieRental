package pl.testaarosa.movierental.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.controller.MovieNotFoundException;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.repositories.DvdMovieRpository;
import pl.testaarosa.movierental.repositories.MockDvdMovie;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DvdMovieServiceTestSuit {

    private MockDvdMovie mockDvdMovie = new MockDvdMovie();

    @InjectMocks
    private DvdMovieServiceImpl dvdMovieService;

    @Mock
    private DvdMovieRpository dvdMovieRpository;

    @Test
    public void testFindAll() throws ExecutionException, InterruptedException {
        //given
        when(dvdMovieRpository.findAll()).thenReturn(mockDvdMovie.dvdMovieList());
        //when
        int result = dvdMovieService.findAll().size();
        int expect = 3;
        List<DvdMovie> resultList = dvdMovieRpository.findAll();
        //then
        assertEquals(expect,result);
        assertEquals(mockDvdMovie.dvdMovieList(), resultList);

    }

    @Test
    public void testFindById() throws ExecutionException, InterruptedException, MovieNotFoundException {
        //given
        when(dvdMovieRpository.findOne(2L)).thenReturn(mockDvdMovie.dvdMovieList().get(1));
        //when
        DvdMovie result = dvdMovieService.findById(2L);
        DvdMovie expect = mockDvdMovie.dvdMovieList().get(1);
        //then
        assertEquals(expect,result);
        assertNotEquals(expect,mockDvdMovie.dvdMovieList().get(0));
    }

    @Test
    public void testFindByTitle() throws ExecutionException, InterruptedException {
        //given
        when(dvdMovieRpository.findAllByTitleContaining("DvdMovie2")).thenReturn(mockDvdMovie.dvdMovieList());
        //when
        List<DvdMovie> result = dvdMovieService.findByTitle("DvdMovie2");
        List<DvdMovie> expect = mockDvdMovie.dvdMovieList();
        //then
        assertEquals(3, result.size());
        assertEquals(expect, result);
    }

    @Test
    public void testAddDvdMovieTrue() throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        //given
        DvdMovie emptyMovie = new DvdMovie();
        DvdMovie addMovie = mockDvdMovie.dvdMovieList().get(0);
        when(dvdMovieRpository.save(addMovie)).thenReturn(emptyMovie);
        when(dvdMovieRpository.existsAllByImdbID(addMovie.getImdbID())).thenReturn(true);
        //when
        DvdMovie result = dvdMovieService.addDvdMovie(addMovie, addMovie.getDvdMovieDetails());
        //then
        assertEquals(emptyMovie,result);
    }

    @Test
    public void testAddDvdMovieFalse() throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        //given
        DvdMovie addMovie = mockDvdMovie.dvdMovieList().get(1);
        when(dvdMovieRpository.save(addMovie)).thenReturn(addMovie);
        when(dvdMovieRpository.existsAllByImdbID(addMovie.getImdbID())).thenReturn(false);
        //when
        DvdMovie result = dvdMovieService.addDvdMovie(addMovie, addMovie.getDvdMovieDetails());
        //then
        assertEquals(addMovie,result);
    }
}
