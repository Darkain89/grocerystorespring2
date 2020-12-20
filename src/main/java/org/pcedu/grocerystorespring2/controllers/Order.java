/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.controllers;

import java.util.List;
import org.pcedu.grocerystorespring2.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mac
 */
@Controller
@RequestMapping(value = {"/order"})
public class Order {

    @Autowired
    OrderService ordersService;

    @RequestMapping(value = {"/{id}"})
    public String showOrder(ModelMap view, @PathVariable Integer id) {
        view.addAttribute("projectName", "Grocery Store");
        org.pcedu.grocerystorespring2.entities.Orders order = ordersService.findById(id);
        view.addAttribute("order", order);
        return ("order");
    }

    @RequestMapping("/all")
    public String showOrders(ModelMap view) {
        view.addAttribute("projectName", "Grocery Store");
        List<org.pcedu.grocerystorespring2.entities.Orders> orders;
        orders = ordersService.findAll();
        view.addAttribute("order", orders);
        return ("order");
    }

    // /new (2 methods - GET, POST)
    // /update (2 methods - GET, POST)
    // /delete
    @GetMapping("/delete/{id}")
    public String deleteOrder(ModelMap view, @PathVariable int id) {
        System.out.println("delete id:" + id);
        if (ordersService.delete(id)) {
            view.addAttribute("msg", "Order with id:" + id + "deleted successfuly!");
            return ("redirect:/login");
        }
        view.addAttribute("msg", "Order with id:" + id + "was not deleted!!!");
        return ("redirect:/login");
    }

    // /order/customer/{id}
    @GetMapping("/customer/{id}")
    public String ordersByCustomerId(ModelMap view, @PathVariable String id) {
        List<org.pcedu.grocerystorespring2.entities.Orders> orders
                = ordersService.findByCustomerId(id);
        view.addAttribute("projectName", "Grocery Store");
        view.addAttribute("order", orders);
        return ("order");
    }

}
