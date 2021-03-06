package pl.testaarosa.movierental.repositories;

import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MockOnLineMovieDto {

    private MockOnLineMovieDetails onLineMovieDetails = new MockOnLineMovieDetails();
//    private MockMovieWish mockMovieWish = new MockMovieWish();

    public List<OnLineMovieDto> onLineMovieDtoList() throws ExecutionException, InterruptedException {

        OnLineMovieDto onLineMovie1 = new OnLineMovieDto(
                null,
                "1988",
                "Online TestTitle1",
                "imdbID_O1",
                "www.Online-poster11",
                "On Line",
//        onLineMovie1.setMovieWishList(mockMovieWish.mockMovieWish());
                onLineMovieDetails.onLineMovieDetails().get().get(0));

        OnLineMovieDto onLineMovie2 = new OnLineMovieDto(
                null,
                "2010",
                "Online TestTitle2",
                "imdbID_O2",
                "www.Online-poster12",
                "On Line",
//        onLineMovie1.setMovieWishList(mockMovieWish.mockMovieWish());
                onLineMovieDetails.onLineMovieDetails().get().get(1));

        OnLineMovieDto onLineMovie2EqualsTest = new OnLineMovieDto(
                null,
                "2010",
                "Online TestTitle2",
                "imdbID_O2",
                "www.Online-poster12",
                "On Line",
//        onLineMovie1.setMovieWishList(mockMovieWish.mockMovieWish());
                onLineMovieDetails.onLineMovieDetails().get().get(1));

        List<OnLineMovieDto> onLineMovieList = new ArrayList<>();
        onLineMovieList.add(onLineMovie1);
        onLineMovieList.add(onLineMovie2);
        onLineMovieList.add(onLineMovie2EqualsTest);
        return onLineMovieList;
//        return CompletableFuture.completedFuture(ofNullable(onLineMovieList).orElse(new ArrayList<>()));
    }
}

