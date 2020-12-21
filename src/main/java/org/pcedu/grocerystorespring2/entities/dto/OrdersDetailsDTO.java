/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.entities.dto;

import java.math.BigDecimal;

/**
 *
 * @author George.Pasparakis
 */
public class OrdersDetailsDTO extends OrdersDTO {
    private Integer detailsId;
    private BigDecimal price;
    private int quantity;

    public OrdersDetailsDTO() {
    }

    public OrdersDetailsDTO(Integer detailsId, BigDecimal price, int quantity) {
        this.detailsId = detailsId;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer id) {
        this.detailsId = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
