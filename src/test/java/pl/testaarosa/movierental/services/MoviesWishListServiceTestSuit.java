package pl.testaarosa.movierental.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.domain.MoviesWishList;
import pl.testaarosa.movierental.repositories.MoviesWishListRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoviesWishListServiceTestSuit {
    private List<MoviesWishList> moviesWishLists;

    @InjectMocks
    private MoviesWishListServiceImpl moviesWishListService;

    @Mock
    private MoviesWishListRepository moviesWishListRepository;

    @Before
    public void setUp(){
        moviesWishLists = new ArrayList<>();
        MoviesWishList moviesWishList1 = MoviesWishList.builder()
                .id(1L)
                .supId("ATT01")
                .title("Test Title1")
                .filmGenre("movieGenre1")
                .supplier("testSupplier1")
                .poster("poster1")
                .build();
        MoviesWishList moviesWishList2 = MoviesWishList.builder()
                .id(1L)
                .supId("ATT02")
                .title("Test Title2")
                .filmGenre("movieGenre2")
                .supplier("testSupplier2")
                .poster("poster2")
                .build();

        moviesWishLists.add(moviesWishList1);
        moviesWishLists.add(moviesWishList2);
    }

    @Test
    public void testFindAll(){
        //givem
        when(moviesWishListRepository.findAll()).thenReturn(moviesWishLists);
        //when
        List<MoviesWishList> result = moviesWishListService.findAll();
        List<MoviesWishList> expect = moviesWishLists;
        //then
        assertEquals(expect,result);
    }
}
