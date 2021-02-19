package com.avivasa.client;

import com.avivasa.controllers.CustomerController;
import com.avivasa.models.*;
import com.avivasa.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class InsuranceApiClient {
    public static void main(String[] args) {

        //saveTestData();

        Customer customer = new Customer("Veli","Ankara",654634634634L);
        //new CustomerController().saveCustomer(customer);
        List<Customer> customers = new CustomerController().findAllCustomers();
        customers.stream().filter(customer1 -> customer1.getVehicles().size()>=1).forEach(c -> System.out.println(c.getName() + " has vehicle : " + c.getVehicles().get(0).getV_model()));

        List<Vehicle> vehicles = new CustomerController().findVehiclesOfCustomers(62345475327L);
        System.out.println("*********** VEHICLES OF UFUK : **********");
        vehicles.stream().forEach(System.out::println);
    }

    private static void saveTestData() {
        Customer customer1 = new Customer("Koray","Istanbul",46273672364L);
        Customer customer2 = new Customer("Ufuk","Izmir",62345475327L);

        Vehicle car1 = new Car("Porsche Cayenne", 2020,"34VG5845","red");
        Vehicle car2 = new Car("Bugatti Chiron", 2021, "34AA443","Black");
        Vehicle moto1 = new Motorcycle("Harley-Davidson", 2018,"34VG5845",1.8);

        car1.setCustomer(customer1);
        car2.setCustomer(customer2);
        moto1.setCustomer(customer2);


        Accident accident1 = new Accident(LocalDate.of(2021, Month.APRIL, 11));
        Accident accident2 = new Accident(LocalDate.of(2020, Month.DECEMBER, 21));
        Accident accident3 = new Accident(LocalDate.of(2019, Month.MAY, 3));

        car1.getAccidents().add(accident1);
        car2.getAccidents().add(accident1);
        moto1.getAccidents().add(accident2);
        moto1.getAccidents().add(accident3);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        try {
            em.getTransaction().begin();

            em.persist(car1);
            em.persist(car2);
            em.persist(moto1);

            em.persist(customer1);
            em.persist(customer2);

            em.persist(accident1);
            em.persist(accident2);
            em.persist(accident3);

            em.getTransaction().commit();

            System.out.println("Data persisted...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
