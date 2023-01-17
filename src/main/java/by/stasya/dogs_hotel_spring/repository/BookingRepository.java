package by.stasya.dogs_hotel_spring.repository;

import by.stasya.dogs_hotel_spring.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
//    List<Booking> findByNameStartingWithIgnoreCase(String prefix);
}
