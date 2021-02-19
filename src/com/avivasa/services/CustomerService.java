package com.avivasa.services;

import com.avivasa.models.Customer;
import com.avivasa.models.Vehicle;
import com.avivasa.repository.CrudRepository;
import com.avivasa.repository.CustomerRepository;
import com.avivasa.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerService implements CrudRepository<Customer>, CustomerRepository {
    @Override
    public List<Customer> findAll() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        List<Customer> customers = em.createQuery("from Customer", Customer.class).getResultList();
        EntityManagerUtils.closeEntityManager(em);
        return customers;
    }

    @Override
    public Customer findById(int id) {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        Customer customer = em.find(Customer.class,id);
        EntityManagerUtils.closeEntityManager(em);
        return customer;
    }

    @Override
    public void saveToDatabase(Customer customer) {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        EntityManagerUtils.closeEntityManager(em);
    }

    @Override
    public void deleteFromDatabase(Customer object) {

    }

    @Override
    public void deleteFromDatabase(int id) {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        em.getTransaction().begin();
        Customer customer = findById(id);
        em.remove(customer);
        EntityManagerUtils.closeEntityManager(em);
        em.getTransaction().commit();
    }

    @Override
    public void updateOnDatabase(Customer object) {

    }

    @Override
    public boolean isExistsOnDatabase(long SSID) {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        Customer c = em.createQuery("from Customer c WHERE c.ssid =:customerSSID", Customer.class).
                setParameter("customerSSID",SSID).getSingleResult();
        if(c != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Vehicle> findVehiclesOfCustomers(long SSID) {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        List<Vehicle> vehicleList = em.createQuery("from Vehicle v WHERE v.customer.ssid =:ssid", Vehicle.class).
                setParameter("ssid",SSID).getResultList();
        EntityManagerUtils.closeEntityManager(em);
        return vehicleList;
    }
}
