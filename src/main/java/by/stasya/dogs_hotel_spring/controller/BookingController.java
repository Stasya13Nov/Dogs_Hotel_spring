package by.stasya.dogs_hotel_spring.controller;

import by.stasya.dogs_hotel_spring.model.Booking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import by.stasya.dogs_hotel_spring.service.BookingService;

import javax.validation.Valid;
import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {

private final BookingService bookingService;

    @GetMapping
    public String getAll(Model model) {
        List<Booking> bookingList = bookingService.findAll();
        model.addAttribute("bookings", bookingList);
        return "booking/index";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        return "booking/show";
    }

    //форма для бронирования
    @GetMapping("/new")
    public String createForm(@ModelAttribute("booking") Booking booking) {


        return "booking/new";
    }

    @PostMapping
    public String create(@ModelAttribute("booking") @Valid Booking booking, BindingResult bindingResult) {
       if(bindingResult.hasErrors()){
           return "booking/new";
       }
       bookingService.save(booking);
       return "redirect:/booking";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        bookingService.delete(id);
        return "redirect:/booking";
    }

    //форма для редактирования
    @GetMapping("/{id}/edit")
    public String updateForm(@PathVariable("id") int id, Model model) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        return "booking/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("booking") @Valid Booking booking, BindingResult bindingResult,
                                @PathVariable("id") int id) {
        if (bindingResult.hasErrors()){
            return "booking/edit";
        }
        bookingService.partialUpdate(id, booking);
        return "redirect:/booking";
    }

//    @GetMapping("/prefix")
//    public List<Booking> getByPrefix(@RequestParam String prefix) {
//        return bookingService.findByPrefix(prefix);
//    }





}
