/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.services;

import java.util.ArrayList;
import java.util.List;
import org.pcedu.grocerystorespring2.dao.CustomerDao;
import org.pcedu.grocerystorespring2.entities.Customer;
import org.pcedu.grocerystorespring2.entities.Orders;
import org.pcedu.grocerystorespring2.entities.dto.CustomerDTO;
import org.pcedu.grocerystorespring2.entities.dto.CustomerOrderDetailsDTO;
import org.pcedu.grocerystorespring2.entities.dto.CustomerOrdersDTO;
import org.pcedu.grocerystorespring2.entities.dto.OrdersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author George.Pasparakis
 */
@Service("customerService")
@Transactional
public class CustomerService {
    @Autowired
    CustomerDao dao;
    
    public Customer findById(int id) {
        return dao.findById(id);
    }
    
    public CustomerDTO findByIdDTO(int id) {
        Customer customer = findById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setTel(customer.getTel());
        customerDTO.setEmail(customer.getEmail());
        return(customerDTO);
    }
    
    // Step  1. Do some inheritance magic, create CustomerOrdersDTO extends CustomerDTO
    // Step 2a. Create from customerService findOrdersByCustomerIdDTO
    // Step 2b. Fill customer's data like findByIdDTO (CustomerService Service)
    // Step  3. Create OrdersDTO
    // Step  4. Fill List of CustomerOrdersDTO (OrdersDTO) with orders' data
    public CustomerOrdersDTO findOrdersByCustomerIdDTO(int id) {
        Customer customer = findById(id);
        CustomerOrdersDTO customerOrdersDTO = new CustomerOrdersDTO();
        
        // customer's details
        customerOrdersDTO.setId(customer.getId());
        customerOrdersDTO.setFirstName(customer.getFirstName());
        customerOrdersDTO.setLastName(customer.getLastName());
        customerOrdersDTO.setTel(customer.getTel());
        customerOrdersDTO.setEmail(customer.getEmail());
        
        // orders' data
        List<Orders> orders = customer.getOrdersList();
       
        List<OrdersDTO> ordersDTO = new ArrayList<OrdersDTO>();
        for (Orders order : orders) {
            ordersDTO.add(new OrdersDTO(order.getId(), order.getDate(), order.getTotalPrice()));
        }
        customerOrdersDTO.setOrders(ordersDTO);
        return(customerOrdersDTO);
    }
    
    
    // change return type!!!!
    public CustomerOrderDetailsDTO findOrdersAndDetailsByCustomerIdDTO(int id) {
        Customer customer = findById(id);
        CustomerOrdersDTO customerOrdersDTO = new CustomerOrdersDTO();
        CustomerOrderDetailsDTO customerOrderDetailsDTO = new CustomerOrderDetailsDTO();
        
        // customer's details
        customerOrdersDTO.setId(customer.getId());
        customerOrdersDTO.setFirstName(customer.getFirstName());
        customerOrdersDTO.setLastName(customer.getLastName());
        customerOrdersDTO.setTel(customer.getTel());
        customerOrdersDTO.setEmail(customer.getEmail());
        
        // orders' data
        List<Orders> orders = customer.getOrdersList();
       
        List<OrdersDTO> ordersDTO = new ArrayList<OrdersDTO>();
        for (Orders order : orders) {
            ordersDTO.add(new OrdersDTO(order.getId(), order.getDate(), order.getTotalPrice()));
        }
        customerOrdersDTO.setOrders(ordersDTO);
        
        // customerOrderDetailsDTO needs to be filled!!!!
        // orderDetails
        // Prdoduct
        
        return(customerOrderDetailsDTO);
    }
    
    public List<Customer> findAll() {
        return(dao.findAll());
    }
    
    public boolean save(Customer customer) {
        boolean result = false;
        result = dao.save(customer);
        return(result);
    }
    
    public boolean update(Customer customer) {
        return(dao.update(customer));
    }
    
    public boolean delete(int id) {
        return(dao.delete(id));
        
    }
    
    public List<Customer> findByFirstLastNames(String firstName, String lastName) {
        return(dao.findByFirstLastNames(firstName, lastName));
    }
}
