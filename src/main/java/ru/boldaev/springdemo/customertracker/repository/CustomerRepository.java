package ru.boldaev.springdemo.customertracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.boldaev.springdemo.customertracker.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE LOWER(CONCAT(c.firstName, ' ', c.lastName) ) LIKE %:name% " +
            "OR LOWER(c.firstName) LIKE %:name% OR LOWER(c.lastName) LIKE %:name%")
    List<Customer> findByName(@Param("name") String name);
}
