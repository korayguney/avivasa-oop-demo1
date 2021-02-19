package com.avivasa.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String v_model;
    private int v_year;
    private String v_plate;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Accident> accidents = new ArrayList<>();

    public Vehicle(String v_model, int v_year, String v_plate) {
        this.v_model = v_model;
        this.v_year = v_year;
        this.v_plate = v_plate;
    }

    public Vehicle() {
    }

    public List<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<Accident> accidents) {
        this.accidents = accidents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getV_model() {
        return v_model;
    }

    public void setV_model(String v_model) {
        this.v_model = v_model;
    }

    public int getV_year() {
        return v_year;
    }

    public void setV_year(int v_year) {
        this.v_year = v_year;
    }

    public String getV_plate() {
        return v_plate;
    }

    public void setV_plate(String v_plate) {
        this.v_plate = v_plate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", v_model='" + v_model + '\'' +
                ", v_year=" + v_year +
                ", v_plate='" + v_plate + '\'' +
                '}';
    }
}
