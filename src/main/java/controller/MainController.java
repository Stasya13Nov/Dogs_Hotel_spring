package controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping
    public String string(){
        return "index";
    }
}
