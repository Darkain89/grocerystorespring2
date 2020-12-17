/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.services;

import org.pcedu.grocerystorespring2.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author George.Pasparakis
 */
@Service("productService")
@Transactional
public class Product {

    @Autowired
    ProductDao dao;

    public org.pcedu.grocerystorespring2.entities.Product findById(int id) {
        return dao.findById(id);
    }
}
