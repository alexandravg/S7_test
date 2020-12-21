package ru.alexandravg.entity;

public class PassengerDTO {
    private String name;
    private String flightClass;

    public PassengerDTO() {
    }

    public PassengerDTO(String name, String flightClass) {
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
