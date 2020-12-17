/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pcedu.grocerystorespring2.dao;

import org.pcedu.grocerystorespring2.entities.Product;
import org.springframework.stereotype.Repository;

/**
 *
 * @author George.Pasparakis
 */
@Repository("productDao")
public class ProductDao extends AbstractDao<Integer, Product> {

    public Product findById(int id) {
        Product s = getByKey(id);
        if (s != null) {
            return s;
        }
        return null;
    }
}
