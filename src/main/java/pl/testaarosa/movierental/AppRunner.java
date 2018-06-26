package pl.testaarosa.movierental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.testaarosa.movierental.domain.UserGender;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.services.BlueRayMovieFillDbProcessor;
import pl.testaarosa.movierental.services.DvdMovieFillDbProcessor;
import pl.testaarosa.movierental.services.RoleService;

import java.time.LocalDateTime;
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

        UserFormDto user = new UserFormDto();
        user.setName("Maciej");
        user.setSurname("Wojcik");
        user.setEmail("maciek@testaarosa.pl");
        user.setPassword("admin");
        user.setRegisterDate(LocalDateTime.now().withNano(0));
        user.setBrithday("1979-08-07");
        user.setCity("Izabelin");
        user.setStreet("Chlopickiego 48");
        user.setUserGender(UserGender.NOTSURE);
        userFacade.addUserAndWish(user);

        long start = System.currentTimeMillis();
        blueRayMovieFillDbProcessor.FillBlueRayDb("star");
        blueRayMovieFillDbProcessor.FillBlueRayDb("iron");
        dvdMovieFillDbProcessor.FillDvdMovieDb();
        blueRayMovieFillDbProcessor.FillBlueRayDb("indiana");
        LOGGER.info("\33[33m Elapsed time for fill db dvd+ blureay x3: " + (System.currentTimeMillis() - start));

        CompletableFuture.allOf().join();
    }
}

