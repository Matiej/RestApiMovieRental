package pl.testaarosa.movierental.controllerRest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.testaarosa.movierental.domain.dto.OnLineMovieDto;
import pl.testaarosa.movierental.facade.MoviesFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/mrapi/online/")
@Api(description = "OnLine movie rest controller")
public class OnLineMovieControllerRest {

    @Autowired
    private MoviesFacade moviesFacade;

    @GetMapping("onlinemovielist")
    @ApiOperation(value = "Search onLine movies by title", response = OnLineMovieDto.class)
    @ApiImplicitParam(required = true, name = "title", value = "movie title", dataType = "string", paramType = "query",
            example = "Star Wars")
    public List<OnLineMovieDto> findOnLineMovies(String title) {
        List<OnLineMovieDto> onLineMovieDtoList = new ArrayList<>();
        try {
            onLineMovieDtoList = moviesFacade.getOnLineMovies(title);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return onLineMovieDtoList;
    }


}
