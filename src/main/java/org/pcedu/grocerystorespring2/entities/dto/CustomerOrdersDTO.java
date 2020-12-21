/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.entities.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author George.Pasparakis
 */
public class CustomerOrdersDTO extends CustomerDTO {
    private List<OrdersDTO> orders = new ArrayList<>();

    public List<OrdersDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersDTO> orders) {
        this.orders = orders;
    }
}



