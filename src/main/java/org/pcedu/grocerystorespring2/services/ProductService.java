/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.services;

import org.pcedu.grocerystorespring2.dao.ProductDao;
import org.pcedu.grocerystorespring2.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author George.Pasparakis
 */
@Service("productService")
@Transactional
public class ProductService {

    @Autowired
    ProductDao dao;

    public Product findById(int id) {
        return dao.findById(id);
    }
}
