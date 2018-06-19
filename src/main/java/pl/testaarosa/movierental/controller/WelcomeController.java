package pl.testaarosa.movierental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/home")
    public String startMyApp(){
        return "index";
    }

    @RequestMapping("/")
    public String heroku() {
        return "index_n";
    }

    @RequestMapping("/home_n")
    public String startMyAppN(){
        return "index_n";
    }
}
