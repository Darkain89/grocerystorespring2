/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.controllers;

import com.sun.tools.javac.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        org.pcedu.grocerystorespring2.entities.Customer customer = customerService.findById(Convert.string2int(id, 10));
        view.addAttribute("customer", customer);
        return ("customer");
    }
}
