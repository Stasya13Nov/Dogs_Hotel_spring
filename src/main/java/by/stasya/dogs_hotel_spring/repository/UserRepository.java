package by.stasya.dogs_hotel_spring.repository;

import by.stasya.dogs_hotel_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
