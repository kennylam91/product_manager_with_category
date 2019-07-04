package com.codegym.pms.service;

import com.codegym.pms.model.Category;
import com.codegym.pms.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();

    void addProduct(Product product);

    Product findProductById(int id);

    void updateProduct(int key, Product product);

    void deleteProductById(int id);



}
