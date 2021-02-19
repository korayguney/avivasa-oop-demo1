package com.avivasa.controllers;

import com.avivasa.models.Customer;
import com.avivasa.models.Vehicle;
import com.avivasa.services.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService customerService = new CustomerService();

    public Customer findCustomer(int custId){
        return customerService.findById(custId);
    }

    public List<Customer> findAllCustomers(){
        return customerService.findAll();
    }

    public void saveCustomer(Customer customer){
        customerService.saveToDatabase(customer);
    }

    public List<Vehicle> findVehiclesOfCustomers(long ssid){
        return customerService.findVehiclesOfCustomers(ssid);
    }

}
