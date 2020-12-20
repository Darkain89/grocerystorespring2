/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.services;

import java.util.List;
import org.pcedu.grocerystorespring2.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mac
 */
@Service("ordersService")
@Transactional
public class OrderService {

    @Autowired
    OrdersDao dao;

    public org.pcedu.grocerystorespring2.entities.Orders findById(int id) {
        return dao.findById(id);
    }

    public List<org.pcedu.grocerystorespring2.entities.Orders> findAll() {
        return (dao.findAll());
    }

    public boolean save(org.pcedu.grocerystorespring2.entities.Orders order) {
        boolean result = false;
        result = dao.save(order);
        return (result);
    }

    public boolean update(org.pcedu.grocerystorespring2.entities.Orders order) {
        return (dao.update(order));
    }

    public boolean delete(int id) {
        return (dao.delete(id));

    }

    public List<org.pcedu.grocerystorespring2.entities.Orders> findByCustomerId(String customersId) {
        return (dao.findByCustomerId(customersId));
    }

}
