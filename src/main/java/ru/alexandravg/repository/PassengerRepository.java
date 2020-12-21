package ru.alexandravg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexandravg.entity.PassengerEntity;

public interface PassengerRepository extends JpaRepository<PassengerEntity, String> {
}
