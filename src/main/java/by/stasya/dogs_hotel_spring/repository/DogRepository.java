package by.stasya.dogs_hotel_spring.repository;

import by.stasya.dogs_hotel_spring.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Integer> {
}
