package ru.alexandravg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexandravg.entity.PassengerDTO;
import ru.alexandravg.service.FlightService;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {
    Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    @Autowired
    private FlightService flightService;

    @GetMapping(value = "/{flightClass}", produces = "application/json")
    public ResponseEntity getFlightClassInfo(@PathVariable String flightClass) {
        log.info("New GET request for " + flightClass);
        return new ResponseEntity<>(flightService.getFlightClassInfo(flightClass), HttpStatus.OK);
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public HttpStatus registerPassenger(@RequestBody PassengerDTO passengerDTO) {
        if (passengerDTO != null) {
            log.info("New POST request for " + passengerDTO.getName());
            if (flightService.registerPassenger(passengerDTO)) {
                return HttpStatus.OK;
            }
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @GetMapping(value = "/info", produces = "application/json")
    public ResponseEntity getFlightInfo() {
        log.info("New GET request for info");
        return new ResponseEntity(flightService.getFlightInfo(), HttpStatus.OK);
    }

}
