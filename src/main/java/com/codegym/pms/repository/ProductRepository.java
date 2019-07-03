package com.codegym.pms.repository;

import com.codegym.pms.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
