/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.controllers;

import java.util.List;
import javax.validation.Valid;
import org.pcedu.grocerystorespring2.entities.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author George.Pasparakis
 */
@RestController
@RequestMapping(value = {"/api/customer"})
public class CustomerRestController {

    @Autowired
    org.pcedu.grocerystorespring2.services.Customer customerService;

    @GetMapping("/hello")
    public String hello() {
        return ("hello");
    }

    @RequestMapping(value = {"/{id}"})
    public CustomerDTO showCustomer(ModelMap view, @PathVariable String id) {
        view.addAttribute("projectName", "Grocery Store");
        CustomerDTO customerDTO = customerService.findByIdDTO(Integer.parseInt(id));
        return (customerDTO);
    }
    
    // @GetMapping("/{id}/orders")
    // public XXX showCustomerOrders(ModelMap view, @PathVariable String id)

    @RequestMapping("/all")
    public String showCustomers(ModelMap view) {
        view.addAttribute("projectName", "Grocery Store");
        List<org.pcedu.grocerystorespring2.entities.Customer> customers;
        customers = customerService.findAll();
        view.addAttribute("customer", customers);
        return ("customer");
    }

    @RequestMapping("/new")
    public String newCustomer(ModelMap view) {
        view.addAttribute("projectName", "Grocery Store");
        org.pcedu.grocerystorespring2.entities.Customer customer = new org.pcedu.grocerystorespring2.entities.Customer();
        view.addAttribute("customer", customer);
        return ("newcustomer");
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveNewCustomer(ModelMap view,
            @Valid org.pcedu.grocerystorespring2.entities.Customer customer,
            BindingResult bindingResult) {
        view.addAttribute("projectName", "Grocery Store");
        if (bindingResult.hasErrors()) {
            view.addAttribute("error", "There are errors on the form!");
        } else {
            customerService.save(customer);
        }

        return ("newcustomer");
    }

    @GetMapping("/update/{id}")
    public String updateCustomer(ModelMap view, @PathVariable int id) {
        org.pcedu.grocerystorespring2.entities.Customer customer = customerService.findById(id);
        view.addAttribute("customer", customer);
        return ("updatecustomer");
    }

    @PostMapping("/update/saveupdate")
    public String saveUpdateCustomer(ModelMap view,
            org.pcedu.grocerystorespring2.entities.Customer customer) {
        view.addAttribute("projectName", "Grocery Store");
        customerService.update(customer);
        return ("redirect:/login");
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(ModelMap view, @PathVariable int id) {
        if (customerService.delete(id)) {
            view.addAttribute("msg", "Customer with id:" + id + "deleted successfuly!");
            return ("redirect:/login");
        }
        view.addAttribute("msg", "Customer with id:" + id + "was not deleted!!!");
        return ("redirect:/login");
    }

    @GetMapping("/findbynames/{firstName}/{lastName}")
    public String findByFirstLastNames(ModelMap view, @PathVariable String firstName, @PathVariable String lastName) {
        List<org.pcedu.grocerystorespring2.entities.Customer> customers
                = customerService.findByFirstLastNames(firstName, lastName);
        // https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm
        view.addAttribute("customer", customers);
        return ("customer");
    }
}
