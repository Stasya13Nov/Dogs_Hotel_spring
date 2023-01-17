package by.stasya.dogs_hotel_spring.repository;

import by.stasya.dogs_hotel_spring.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
