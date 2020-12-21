/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.services;

import java.util.List;
import org.pcedu.grocerystorespring2.dao.CustomerDao;
import org.pcedu.grocerystorespring2.entities.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author George.Pasparakis
 */
@Service("customerService")
@Transactional
public class Customer {
    @Autowired
    CustomerDao dao;
    
    public org.pcedu.grocerystorespring2.entities.Customer findById(int id) {
        return dao.findById(id);
    }

    public CustomerDTO findByCustomer(org.pcedu.grocerystorespring2.entities.Customer customer) {
        CustomerDTO custDTO = new CustomerDTO();
        custDTO.setId(customer.getId());
        custDTO.setFirstName(customer.getFirstName());
        custDTO.setLastName(customer.getLastName());
        custDTO.setEmail(customer.getEmail());
        custDTO.setTel(customer.getTel());
        return(custDTO);
    }
    
    public List<org.pcedu.grocerystorespring2.entities.Customer> findAll() {
        return(dao.findAll());
    }
    
    public boolean save(org.pcedu.grocerystorespring2.entities.Customer customer) {
        boolean result = false;
        result = dao.save(customer);
        return(result);
    }
    
    public boolean update(org.pcedu.grocerystorespring2.entities.Customer customer) {
        return(dao.update(customer));
    }
    
    public boolean delete(int id) {
        return(dao.delete(id));
        
    }
    
    public List<org.pcedu.grocerystorespring2.entities.Customer> findByFirstLastNames(String firstName, String lastName) {
        return(dao.findByFirstLastNames(firstName, lastName));
    }
}
