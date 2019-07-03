package com.codegym.pms.repository;

import com.codegym.pms.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void addProduct(Product product);

    Product findProductById(int id);

    void updateProduct(int key, Product product);

    void deleteProductById(int id);
}
