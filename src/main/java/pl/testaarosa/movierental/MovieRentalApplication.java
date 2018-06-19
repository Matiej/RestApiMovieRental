package pl.testaarosa.movierental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.testaarosa.movierental.domain.Role;
import pl.testaarosa.movierental.domain.User;
import pl.testaarosa.movierental.domain.UserGender;
import pl.testaarosa.movierental.facade.UserFacade;
import pl.testaarosa.movierental.form.UserForm;
import pl.testaarosa.movierental.form.dto.UserFormDto;
import pl.testaarosa.movierental.repositories.UserRepository;
import pl.testaarosa.movierental.services.BlueRayMovieFillDbProcessor;
import pl.testaarosa.movierental.services.DvdMovieFillDbProcessor;
import pl.testaarosa.movierental.services.RoleService;

import java.time.LocalDateTime;

@SpringBootApplication
public class MovieRentalApplication implements CommandLineRunner {

    @Autowired
    private DvdMovieFillDbProcessor dvdMovieFillDbProcessor;
    @Autowired
    private BlueRayMovieFillDbProcessor blueRayMovieFillDbProcessor;
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserFacade userFacade;

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalApplication.class, args);
    }

    public void run(String... strings) throws Exception {

        Role role = roleService.findByName("ADMIN");
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



//        blueRayMovieFillDbProcessor.FillBlueRayDb("list");
//        blueRayMovieFillDbProcessor.FillBlueRayDb("iron");
        dvdMovieFillDbProcessor.FillDvdMovieDb();
//        blueRayMovieFillDbProcessor.FillBlueRayDb("star");
        blueRayMovieFillDbProcessor.FillBlueRayDb("indiana");
    }
}
