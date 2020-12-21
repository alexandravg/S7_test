package ru.alexandravg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "PASSENGER")
public class PassengerEntity {
    @Id
    private String name;
    @Column
    @NotNull
    private String flightClass;

    public PassengerEntity() {
    }

    public PassengerEntity(String name, String flightClass) {
        this.name = name;
        this.flightClass = flightClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
}
