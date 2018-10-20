package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDetailsDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/mrapi/online/")
@Api(description = "OnLine details movie rest controller")
public class OnLineMovieDetailsControllerRest {

    @Autowired
    private MoviesFacade moviesFacade;

    @GetMapping("/onlinedetail")
    @ApiOperation(value = "Search onLine movies details by ImdbID", response = OnLineMovieDetailsDto.class)
    @ApiImplicitParam(required = true, name = "imdbId", value = "movie ID from IMDb", dataType = "string", paramType = "query",
            example = "tt0092769")
    public OnLineMovieDetailsDto findOnLineMovieDetail(String imdbId) {
        OnLineMovieDetailsDto movieDetDto = null;
        try {
            movieDetDto = moviesFacade.getOnLineMovieDetails(imdbId);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return movieDetDto;
    }
}
