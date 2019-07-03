package com.codegym.pms.repository.impl;

import com.codegym.pms.model.Category;
import com.codegym.pms.model.Product;
import com.codegym.pms.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    public static Map<Integer,Product> products;
    public static Map<Integer,Category> categories;
    static{
        categories=new HashMap<>();
        categories.put(1,new Category(1,"smartphone"));
        categories.put(2, new Category(2,"laptop"));
        products=new HashMap<>();
        products.put(1,new Product(1,"Iphone XS",15000,15, categories.get(1)));
        products.put(2,new Product(2,"Thinkpad W541",22000,7, categories.get(2)));
        products.put(3,new Product(3,"Samsung note9",20000,10, categories.get(1)));
        products.put(4,new Product(4,"Macbook pro",35000,3, categories.get(2)));

    }
    @Override
    public List<Product> findAll() {
        return  new ArrayList<>(products.values());
    }
}
