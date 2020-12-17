/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author mac
 */
@Controller
@RequestMapping({"/product"})
public class Product {

    @Autowired
    org.pcedu.grocerystorespring2.services.Product productService;

    @RequestMapping("/{id}")
    public String page(ModelMap view, @PathVariable String id) {
        view.addAttribute("projectName", "Grocery Store");
        org.pcedu.grocerystorespring2.entities.Product product = productService.findById(Integer.parseInt(id));
        view.addAttribute("product", product);
        return "product";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }

}
