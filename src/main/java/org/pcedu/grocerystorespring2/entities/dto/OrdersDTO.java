/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.entities.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author George.Pasparakis
 */
public class OrdersDTO {
    private Integer id;
    private Date date;
    private BigDecimal totalPrice;

    public OrdersDTO() {
    }

    public OrdersDTO(Integer id, Date date, BigDecimal totalPrice) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
