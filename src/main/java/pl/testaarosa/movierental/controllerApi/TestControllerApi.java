package pl.testaarosa.movierental.controllerApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mrapi/")
public class TestControllerApi {

    @GetMapping("test")
    public String test() {
        return "jshjhdjshdjhsjdjs";
    }
}
