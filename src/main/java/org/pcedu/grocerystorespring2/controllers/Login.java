/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author George.Pasparakis
 */
@Controller
@RequestMapping("/")
public class Login {

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET})
    public String login(ModelMap view, @RequestParam("msg") String message) {
        view.addAttribute("projectName", "Grocery Store");
        view.addAttribute("msg", message);
        return ("login");
    }
}
