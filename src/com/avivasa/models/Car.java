package com.avivasa.models;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private String color;

    public Car(String v_model, int v_year, String v_plate, String color) {
        super(v_model, v_year, v_plate);
        this.color = color;
    }

    public Car(String color) {
        this.color = color;
    }

    public Car() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                "} " + super.toString();
    }
}
