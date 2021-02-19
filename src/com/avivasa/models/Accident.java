package com.avivasa.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate a_date;

    @ManyToMany(mappedBy = "accidents")
    private List<Vehicle> vehicles = new ArrayList<>();

    public Accident() {
    }

    public Accident(LocalDate a_date) {
        this.a_date = a_date;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getA_date() {
        return a_date;
    }

    public void setA_date(LocalDate a_date) {
        this.a_date = a_date;
    }

    @Override
    public String toString() {
        return "Accident{" +
                "id=" + id +
                ", a_date=" + a_date +
                '}';
    }
}
