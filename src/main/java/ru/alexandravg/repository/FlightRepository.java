package ru.alexandravg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexandravg.entity.FlightEntity;

import java.util.UUID;

public interface FlightRepository extends JpaRepository<FlightEntity, UUID> {
}
