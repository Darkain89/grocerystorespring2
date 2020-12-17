/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.pcedu.grocerystorespring2.entities.Customer;
import org.springframework.stereotype.Repository;

/**
 *
 * @author George.Pasparakis
 */
@Repository("customerDao")
public class CustomerDao extends AbstractDao<Integer, Customer> {
    public Customer findById(int id) {
        Customer s = getByKey(id);
        if(s != null) {
            return s;
        }
        return null;
    }
    
    public List<Customer> findAll() {
         Criteria criteria = createEntityCriteria();
         return((List<Customer>)criteria.list());
                 
    }
    
    public boolean save(Customer customer) {
        return(persist(customer));
    }
}
