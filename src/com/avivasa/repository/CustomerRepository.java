package com.avivasa.repository;

import com.avivasa.models.Vehicle;

import java.util.List;

public interface CustomerRepository {
    boolean isExistsOnDatabase(long SSID);
    List<Vehicle> findVehiclesOfCustomers(long SSID);
}
