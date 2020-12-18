/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
    
    public boolean update(Customer customer) {
        Customer tempCustomer = findById(customer.getId());
        if(tempCustomer != null) {
            tempCustomer.setFirstName(customer.getFirstName());
            tempCustomer.setLastName(customer.getLastName());
            tempCustomer.setEmail(customer.getEmail());
            tempCustomer.setTel(customer.getTel());
            return(save(tempCustomer));
        } else return(false);
    }
    
    public boolean delete(int id) {
        Customer tempCustomer = findById(id);
        if(tempCustomer != null) {
            delete(tempCustomer);
            return(true);
        }
        return(false);
    }
    
    public List<Customer> findByFirstLastNames(String firstName, String lastName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("firstName", firstName));
        criteria.add(Restrictions.eq("lastName", lastName));
        return(criteria.list());
    }
}
