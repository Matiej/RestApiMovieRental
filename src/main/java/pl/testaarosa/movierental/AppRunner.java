package pl.testaarosa.movierental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.BlueRayMovie;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.services.BlueRayMovieFillDbProcessor;
import pl.testaarosa.movierental.services.DvdMovieFillDbProcessor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private DvdMovieFillDbProcessor dvdMovieFillDbProcessor;
    @Autowired
    private BlueRayMovieFillDbProcessor blueRayMovieFillDbProcessor;
    @Autowired
    private UserFacade userFacade;

    @Override
    public void run(String... args) throws Exception {

//        UserFormDto user = new UserFormDto();
//        user.setName("Maciej");
//        user.setSurname("Wojcik");
//        user.setEmail("maciek@testaarosa.pl");
//        user.setPassword("admin");
//        user.setRegisterDate(LocalDateTime.now().withNano(0));
//        user.setBirthday("1979-08-07");
//        user.setCitshy("Izabelin");
//        user.setStreet("Chlopickiego 48");
//        user.setUserGender(UserGender.NOTSURE);
//        userFacade.addUserAndWish(user);

        long start = System.currentTimeMillis();
        CompletableFuture<List<BlueRayMovie>> bb0 = blueRayMovieFillDbProcessor.fillBlueRayDb("star");
        CompletableFuture<List<BlueRayMovie>> bb1 = blueRayMovieFillDbProcessor.fillBlueRayDb("iron");
        dvdMovieFillDbProcessor.fillDvdMovieDb();
        CompletableFuture<List<BlueRayMovie>> bb2 =blueRayMovieFillDbProcessor.fillBlueRayDb("indiana");
        CompletableFuture<List<BlueRayMovie>> bb3 =blueRayMovieFillDbProcessor.fillBlueRayDb("commando");
        CompletableFuture.allOf(bb0, bb1, bb2, bb3).join();
        bb0.get();
        bb1.get();
        bb2.get();
        bb3.get();
        LOGGER.info("\33[33m Elapsed time for fill db dvd+ blureay x3: " + (System.currentTimeMillis() - start) + "\033[0m");
    }
}

