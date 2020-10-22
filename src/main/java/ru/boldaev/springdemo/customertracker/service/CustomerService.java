package ru.boldaev.springdemo.customertracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.boldaev.springdemo.customertracker.model.Customer;
import ru.boldaev.springdemo.customertracker.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.getOne(id);
    }

    public void saveOrUpdate(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> findByName(String name) {

        if (name != null && name.trim().length() > 0) {
            return customerRepository.findByName(name.toLowerCase().trim());
        }
        return customerRepository.findAll();
    }
}
