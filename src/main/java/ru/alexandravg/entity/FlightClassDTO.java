package ru.alexandravg.entity;

import java.util.HashSet;
import java.util.Set;

public class FlightClassDTO {
    private Set<String> business;
    private Set<String> economy;

    public FlightClassDTO() {
        business = new HashSet<>();
        economy = new HashSet<>();
    }

    public Set<String> getBusiness() {
        return business;
    }

    public void setBusiness(Set<String> business) {
        this.business = business;
    }

    public Set<String> getEconomy() {
        return economy;
    }

    public void setEconomy(Set<String> economy) {
        this.economy = economy;
    }

}
