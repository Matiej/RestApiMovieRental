//package pl.testaarosa.movierental.services;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import pl.testaarosa.movierental.domain.MoviesWish;
//import pl.testaarosa.movierental.repositories.MoviesWishListRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class MoviesWishServiceTestSuit {
//    private List<MoviesWish> moviesWishes;
//
//    @InjectMocks
//    private MoviesWishListServiceImpl moviesWishListService;
//
//    @Mock
//    private MoviesWishListRepository moviesWishListRepository;
//
//    @Before
//    public void setUp(){
//        moviesWishes = new ArrayList<>();
//        MoviesWish moviesWish1 = MoviesWish.builder()
//                .id(1L)
//                .supId("ATT01")
//                .title("Test Title1")
//                .filmGenre("movieGenre1")
//                .supplier("testSupplier1")
//                .poster("poster1")
//                .build();
//        MoviesWish moviesWish2 = MoviesWish.builder()
//                .id(1L)
//                .supId("ATT02")
//                .title("Test Title2")
//                .filmGenre("movieGenre2")
//                .supplier("testSupplier2")
//                .poster("poster2")
//                .build();
//
//        moviesWishes.add(moviesWish1);
//        moviesWishes.add(moviesWish2);
//    }
//
//    @Test
//    public void testFindAll(){
//        //givem
//        when(moviesWishListRepository.findAllUsersMoviesForGivenUser()).thenReturn(moviesWishes);
//        //when
//        List<MoviesWish> result = moviesWishListService.findAllUsersMoviesForGivenUser();
//        List<MoviesWish> expect = moviesWishes;
//        //then
//        assertEquals(expect,result);
//    }
//}
