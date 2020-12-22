package ru.alexandravg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alexandravg.entity.FlightClassDTO;
import ru.alexandravg.entity.FlightEntity;
import ru.alexandravg.entity.PassengerDTO;
import ru.alexandravg.entity.PassengerEntity;
import ru.alexandravg.repository.FlightRepository;
import ru.alexandravg.repository.PassengerRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    @PostConstruct
    private void fillOneRecord() {
        FlightEntity flightEntity = new FlightEntity(UUID.randomUUID(), 2, 10, 0, 0);
        flightRepository.save(flightEntity);
    }

    public Integer getFlightClassInfo(String classFlight) {
        FlightEntity flightEntity = flightRepository.findAll().get(0);
        switch (classFlight.toLowerCase()) {
            case "business": {
                return flightEntity.getBusinessClass() - flightEntity.getBusinessClassTaken();
            }
            case "economy": {
                return flightEntity.getEconomyClass() - flightEntity.getEconomyClassTaken();
            }
            default: {
                return null;
            }
        }
    }

    public boolean registerPassenger(PassengerDTO passengerDTO) {
        if(passengerRepository.findById(passengerDTO.getName()).isPresent()){
            return false;
        }
        FlightEntity flightEntity = flightRepository.findAll().get(0);
        if (passengerDTO.getFlightClass().equalsIgnoreCase("business")) {
            if (flightEntity.getBusinessClassTaken() < flightEntity.getBusinessClass()) {
                flightEntity.setBusinessClassTaken(flightEntity.getBusinessClassTaken() + 1);
                PassengerEntity passengerEntity = new PassengerEntity(passengerDTO.getName(),
                        passengerDTO.getFlightClass().toLowerCase());
                flightRepository.save(flightEntity);
                passengerRepository.save(passengerEntity);
                return true;
            } else {
                return false;
            }
        } else {
            if (passengerDTO.getFlightClass().equalsIgnoreCase("economy")) {
                if (flightEntity.getEconomyClassTaken() < flightEntity.getEconomyClass()) {
                    flightEntity.setEconomyClassTaken(flightEntity.getEconomyClassTaken() + 1);
                    PassengerEntity passengerEntity = new PassengerEntity(passengerDTO.getName(),
                            passengerDTO.getFlightClass().toLowerCase());
                    flightRepository.save(flightEntity);
                    passengerRepository.save(passengerEntity);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public FlightClassDTO getFlightInfo() {
        FlightClassDTO flightClass = new FlightClassDTO();
        Set<String> business = new HashSet<>();
        Set<String> economy = new HashSet<>();
        List<PassengerEntity> passengers = passengerRepository.findAll();
        for (PassengerEntity passenger : passengers) {
            if (passenger.getFlightClass().equalsIgnoreCase("business")) {
                business.add(passenger.getName());
            } else {
                economy.add(passenger.getName());
            }
        }
        flightClass.setBusiness(business);
        flightClass.setEconomy(economy);
        return flightClass;
    }

}
