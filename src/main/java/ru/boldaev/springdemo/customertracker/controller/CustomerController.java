package ru.boldaev.springdemo.customertracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.boldaev.springdemo.customertracker.Service.CustomerService;
import ru.boldaev.springdemo.customertracker.model.Customer;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String findAll(Model model) {

        List<Customer> customers = customerService.findAll();

        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/newCustomer")
    public String showFormForAdd(Model model) {

        Customer customer = new Customer();

        model.addAttribute(customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        System.out.println("Binding result: " + bindingResult);

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        customerService.saveOrUpdate(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long id) {

        customerService.delete(id);

        return "redirect:/customer/list";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {

        Customer customer = customerService.findById(id);

        model.addAttribute(customer);

        return "customer-form";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName, Model model) {

        List<Customer> customers = customerService.findByName(searchName);

        model.addAttribute("customers", customers);

        return "list-customers";
    }

}
