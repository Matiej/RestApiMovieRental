package pl.testaarosa.movierental.controllerApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerWelcomeController {

    @RequestMapping("/sw")
    public String redirectToUi() {
        return "redirect:/swagger-ui.html#/";
    }
}

