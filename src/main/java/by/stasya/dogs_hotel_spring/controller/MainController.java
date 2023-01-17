package by.stasya.dogs_hotel_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping
    public String getAllInfo(){
        return "index";
    }
}
