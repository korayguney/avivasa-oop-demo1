package com.avivasa.models;

import javax.persistence.Entity;

@Entity
public class Motorcycle extends Vehicle{
    private double motor_power;

    public Motorcycle(String v_model, int v_year, String v_plate, double motor_power) {
        super(v_model, v_year, v_plate);
        this.motor_power = motor_power;
    }

    public Motorcycle(double motor_power) {
        this.motor_power = motor_power;
    }

    public Motorcycle() {
    }

    public double getMotor_power() {
        return motor_power;
    }

    public void setMotor_power(double motor_power) {
        this.motor_power = motor_power;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "motor_power=" + motor_power +
                "} " + super.toString();
    }
}
