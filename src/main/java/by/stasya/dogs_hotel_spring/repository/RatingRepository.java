package by.stasya.dogs_hotel_spring.repository;

import by.stasya.dogs_hotel_spring.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
