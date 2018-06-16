//package pl.testaarosa.movierental.services;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import pl.testaarosa.movierental.domain.DvdMovie;
//import pl.testaarosa.movierental.repositories.DvdMovieRpository;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DvdMovieServiceTestSuit {
//
//    private List<DvdMovie> dvdMovieList;
//    private List<DvdMovie> dvdMovieList3;
//
//    @InjectMocks
//    private DvdMovieServiceImpl dvdMovieService;
//
//    @Mock
//    private DvdMovieRpository dvdMovieRpository;
//
//    @Before
//    public void setUp(){
//        dvdMovieList = new ArrayList<>();
//        dvdMovieList3 = new LinkedList<>();
//        DvdMovie dvdMovie1 = DvdMovie.builder()
//                .id(1L)
//                .title("title1")
//                .imdbID("AA00T1")
//                .countryOfOrigin("China")
//                .type("comedy")
//                .poster("testposter1")
//                .price(16.4)
//                .build();
//        DvdMovie dvdMovie2 = DvdMovie.builder()
//                .id(2L)
//                .title("Test title2")
//                .imdbID("AA00T2")
//                .countryOfOrigin("RPA")
//                .type("drama")
//                .poster("testposter2")
//                .price(0.16)
//                .build();
//        DvdMovie dvdMovie3 = DvdMovie.builder()
//                .id(3L)
//                .title("Test title3")
//                .imdbID("AA00T3")
//                .countryOfOrigin("Peru")
//                .type("document")
//                .poster("testposter3")
//                .price(11.11)
//                .build();
//        DvdMovie dvdMovie4 = DvdMovie.builder()
//                .id(4L)
//                .title("Test title4")
//                .imdbID("AA00T4")
//                .countryOfOrigin("UK")
//                .type("family")
//                .poster("testposter4")
//                .price(46.1)
//                .build();
//        dvdMovieList.add(dvdMovie1);
//        dvdMovieList.add(dvdMovie2);
//        dvdMovieList.add(dvdMovie3);
//        dvdMovieList.add(dvdMovie4);
//        dvdMovieList3.add(dvdMovie2);
//        dvdMovieList3.add(dvdMovie3);
//        dvdMovieList3.add(dvdMovie4);
//    }
//
//    @Test
//    public void testFindAll(){
//        //given
//        when(dvdMovieRpository.findAll()).thenReturn(dvdMovieList);
//        //when
//        int result = dvdMovieService.findAll().size();
//        int expect = 4;
//        List<DvdMovie> resultList = dvdMovieRpository.findAll();
//        //then
//        assertEquals(expect,result);
//        assertEquals(dvdMovieList, resultList);
//
//    }
//
//    @Test
//    public void testFindById(){
//        //given
//        when(dvdMovieRpository.findOne(2L)).thenReturn(dvdMovieList.get(3));
//        //when
//        DvdMovie result = dvdMovieService.findById(2L);
//        DvdMovie expect = dvdMovieList.get(3);
//        //then
//        assertEquals(expect,result);
//    }
//
//    @Test
//    public void testFindByTitle(){
//        //given
//        when(dvdMovieRpository.findAllByTitleContaining("Test")).thenReturn(dvdMovieList3);
//        //when
//        List<DvdMovie> result = dvdMovieService.findByTitle("Test");
//        List<DvdMovie> expect = dvdMovieList3;
//        assertEquals(3, result.size());
//        assertEquals(expect, result);
//    }
//}
