/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author George.Pasparakis
 */
@Controller
@RequestMapping(value = {"/customer"})
public class Customer {

    @Autowired
    org.pcedu.grocerystorespring2.services.Customer customerService;

    @RequestMapping(value = {"/{id}"})
    public String showCustomer(ModelMap view, @PathVariable String id) {
        view.addAttribute("projectName", "Grocery Store");
        org.pcedu.grocerystorespring2.entities.Customer customer = customerService.findById(Integer.parseInt(id));
        view.addAttribute("customer", customer);
        return ("customer");
    }
    
    @RequestMapping("/all")
    public String showCustomers(ModelMap view) {
        view.addAttribute("projectName", "Grocery Store");
        List<org.pcedu.grocerystorespring2.entities.Customer> customers;
        customers = customerService.findAll();
        view.addAttribute("customer", customers);
        return("customer");
    }
    
    @RequestMapping("/new")
    public String newCustomer(ModelMap view) {
        view.addAttribute("projectName", "Grocery Store");
        org.pcedu.grocerystorespring2.entities.Customer customer = new org.pcedu.grocerystorespring2.entities.Customer();
        view.addAttribute("customer", customer);
        return("newcustomer");
    }
    
    @RequestMapping(value="/new",method = RequestMethod.POST)
    public String saveNewCustomer(ModelMap view, 
                          @Valid org.pcedu.grocerystorespring2.entities.Customer customer,
                          BindingResult bindingResult) {
        view.addAttribute("projectName", "Grocery Store");
        if(bindingResult.hasErrors()) {
           view.addAttribute("error", "There are errors on the form!");
        } else {
            customerService.save(customer);
        }
        
        return("newcustomer");
    }
}
