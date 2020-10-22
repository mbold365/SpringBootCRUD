package ru.boldaev.springdemo.customertracker.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please enter your name")
    @Size(min = 2, max = 45, message = "Name size must be between 2 and 45 letters")
    @Pattern(regexp = "\\p{L}+", message = "Name must contain only letters")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Please enter your surname")
    @Size(min = 2, max = 45, message = "Surname size must be between 2 and 45 letters")
    @Pattern(regexp = "\\p{L}+", message = "Surname must contain only letters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Please enter your email")
    @Size(min = 5, max = 45, message = "Invalid email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Please enter your address")
    @Size(min = 3, max = 100, message = "Invalid address")
    @Pattern(regexp="^[a-zA-z, -]+", message="Address must contain only letters")
    @Column
    private String address;
}
