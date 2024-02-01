package ru.boldaev.springdemo.customertracker.service;

import ru.boldaev.springdemo.customertracker.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    void saveOrUpdate(Customer customer);

    void delete(Long id);

    List<Customer> findByName(String name);

}
