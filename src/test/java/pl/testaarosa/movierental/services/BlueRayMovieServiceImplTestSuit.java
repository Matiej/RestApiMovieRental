//package pl.testaarosa.movierental.services;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import pl.testaarosa.movierental.domain.BlueRayMovie;
//import pl.testaarosa.movierental.repositories.BlueRayMovieRepository;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class BlueRayMovieServiceImplTestSuit {
//
//    private List<BlueRayMovie> blueRayMovieList;
//
//    @InjectMocks
//    private BlueRayMovieServiceImpl movieService;
//
//    @Mock
//    private BlueRayMovieRepository movieRepository;
//
//    @Before
//    public void setUp(){
//        blueRayMovieList = new LinkedList<>();
//        BlueRayMovie blueRayMovie1 = new BlueRayMovie();
//        blueRayMovie1.setId(1L);
//        blueRayMovie1.setImdbID("ttimdBID1");
//        blueRayMovie1.setPoster("poster1 https");
//        blueRayMovie1.setTitle("Test Title1");
//        blueRayMovie1.setType("Test Title1");
//        blueRayMovie1.setYear("2018");
//
//        BlueRayMovie blueRayMovie2 = new BlueRayMovie();
//        blueRayMovie2.setId(2L);
//        blueRayMovie2.setImdbID("ttimdBID2");
//        blueRayMovie2.setPoster("poster2 https");
//        blueRayMovie2.setTitle("Test Title2");
//        blueRayMovie2.setType("Test Title2");
//        blueRayMovie2.setYear("2015");
//
//        BlueRayMovie blueRayMovie3 = new BlueRayMovie();
//        blueRayMovie3.setId(3L);
//        blueRayMovie3.setImdbID("ttimdBID3");
//        blueRayMovie3.setPoster("poster3 https");
//        blueRayMovie3.setTitle("Test Title3");
//        blueRayMovie3.setType("Test Title3");
//        blueRayMovie3.setYear("2014");
//        blueRayMovieList.add(blueRayMovie1);
//        blueRayMovieList.add(blueRayMovie2);
//        blueRayMovieList.add(blueRayMovie3);
//
//   }
//
//    @Test
//    public void testFindAll(){
//        //given
//        when(movieRepository.findAllUsersMoviesForGivenUser()).thenReturn(blueRayMovieList);
//        //when
//        int result = movieService.findAllUsersMoviesForGivenUser().size();
//        int expect = 3;
//        //then
//        assertEquals(expect,result);
//        assertEquals(blueRayMovieList, movieRepository.findAllUsersMoviesForGivenUser());
//    }
//
//    @Test
//    public void testFindbyId(){
//        //given
//        when(movieRepository.findOne(2L)).thenReturn(blueRayMovieList.get(1));
//        //when
//        BlueRayMovie result = movieService.findbyId(2L);
//        //then
//        assertEquals(blueRayMovieList.get(1), result);
//
//    }
//
//    @Test
//    public void testFindAllContainsTitle(){
//        //given
//        when(movieRepository.findAllByTitleContaining("Title3")).thenReturn(blueRayMovieList);
//        //when
//        List<BlueRayMovie> result = movieService.findAllContainsTitle("Title3");
//        List<BlueRayMovie> wrongResult = movieRepository.findAllByTitleContaining("Title4");
//        //then
//        assertEquals(blueRayMovieList, result);
//        assertNotEquals(blueRayMovieList, wrongResult);
//        assertEquals(blueRayMovieList.size(), result.size());
//        assertEquals(0, wrongResult.size());
//    }
//}
