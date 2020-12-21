package ru.alexandravg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "FLIGHT")
public class FlightEntity {
    @Id
    private UUID id;
    @Column
    private Integer businessClass;
    @Column
    private Integer economyClass;
    @Column
    private Integer businessClassTaken = 0;
    @Column
    private Integer economyClassTaken = 0;

    public FlightEntity() {
    }

    public FlightEntity(UUID id, Integer businessClass, Integer economyClass, Integer businessClassTaken, Integer economyClassTaken) {
        this.id = id;
        this.businessClass = businessClass;
        this.economyClass = economyClass;
        this.businessClassTaken = businessClassTaken;
        this.economyClassTaken = economyClassTaken;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(Integer businessClass) {
        this.businessClass = businessClass;
    }

    public Integer getEconomyClass() {
        return economyClass;
    }

    public void setEconomyClass(Integer economyClass) {
        this.economyClass = economyClass;
    }

    public Integer getBusinessClassTaken() {
        return businessClassTaken;
    }

    public void setBusinessClassTaken(Integer businessClassTaken) {
        this.businessClassTaken = businessClassTaken;
    }

    public Integer getEconomyClassTaken() {
        return economyClassTaken;
    }

    public void setEconomyClassTaken(Integer economyClassTaken) {
        this.economyClassTaken = economyClassTaken;
    }
}
