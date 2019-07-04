package com.codegym.pms.service.impl;

import com.codegym.pms.model.Category;
import com.codegym.pms.model.Product;
import com.codegym.pms.service.CategoryService;
import com.codegym.pms.service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    public static Map<Integer, Product> products;
    public static Map<Integer, Category> categories = CategoryServiceImpl.categories;
    private CategoryService categoryService = new CategoryServiceImpl();

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone XS", 15000, 15, categories.get(1)));
        products.put(2, new Product(2, "Thinkpad W541", 22000, 7, categories.get(2)));
        products.put(3, new Product(3, "Samsung note9", 20000, 10, categories.get(1)));
        products.put(4, new Product(4, "Macbook pro", 35000, 3, categories.get(2)));

    }

    @Override
    public List<Product> findAllProduct() {
        return new ArrayList<>(products.values());
    }


    @Override
    public void addProduct(Product product) {
        int key = getRandomId();
        product.setId(key);
        int categoryId= product.getCategory().getId();
        product.setCategory(categoryService.findCategoryById(categoryId));
        products.put(key, product);
    }

    @Override
    public Product findProductById(int id) {
        return products.get(id);
    }

    private int getRandomId() {
        int id;
        do {
            Random rd = new Random();
            id = rd.nextInt(10000);
        }
        while(isProductExist(id));
        return id;
    }

    private Category getDefaultCategory() {
        return categories.get(0);
    }

    @Override
    public void updateProduct(int key, Product product) {
        products.put(key, product);
    }

    @Override
    public void deleteProductById(int id) {
        products.remove(id);

    }

    private boolean isProductExist(int id){
        return categories.containsKey(id);
    }


}
