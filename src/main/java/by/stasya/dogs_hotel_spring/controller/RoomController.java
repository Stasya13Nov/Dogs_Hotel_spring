package by.stasya.dogs_hotel_spring.controller;

import by.stasya.dogs_hotel_spring.model.Room;
import by.stasya.dogs_hotel_spring.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping("/{id}")
    public String showRoom(@PathVariable int id, Model model) {
        Room room = service.findById(id);
        model.addAttribute("room", room);
        return "room/show";
    }
}
