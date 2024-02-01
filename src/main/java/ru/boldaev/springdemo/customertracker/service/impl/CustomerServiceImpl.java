package ru.boldaev.springdemo.customertracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boldaev.springdemo.customertracker.model.Customer;
import ru.boldaev.springdemo.customertracker.repository.CustomerRepository;
import ru.boldaev.springdemo.customertracker.service.CustomerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        if (name != null && name.trim().length() > 0) {
            return customerRepository.findByName(name.toLowerCase().trim());
        }
        return customerRepository.findAll();
    }

}
