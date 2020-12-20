/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.pcedu.grocerystorespring2.entities.Orders;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mac
 */
@Repository("ordersDao")
public class OrdersDao extends AbstractDao<Integer, Orders> {

    public Orders findById(int id) {
        Orders s = getByKey(id);
        if (s != null) {
            return s;
        }
        return null;
    }

    public List<Orders> findAll() {
        Criteria criteria = createEntityCriteria();
        //return((List<Customer>)criteria.list());
        return (criteria.list());

    }

    public boolean save(Orders order) {
        return (persist(order));
    }

    public boolean update(Orders order) {
        Orders tempOrder = findById(order.getId());
        if (tempOrder != null) {
            tempOrder.setDate(order.getDate());
            tempOrder.setTotalPrice(order.getTotalPrice());
            tempOrder.setCustomersId(order.getCustomersId());
            tempOrder.setOrdersDetailsList(order.getOrdersDetailsList());
            return (save(tempOrder));
        } else {
            return (false);
        }
    }

    public boolean delete(int id) {
        Orders tempOrder = findById(id);
        if (tempOrder != null) {
            delete(tempOrder);
            return (true);
        }
        return (false);
    }

    public List<Orders> findByCustomerId(Integer customersId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("customersId", customersId));
        return (criteria.list());
    }
}
