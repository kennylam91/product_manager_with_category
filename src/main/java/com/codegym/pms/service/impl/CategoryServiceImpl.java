package com.codegym.pms.service.impl;

import com.codegym.pms.model.Category;
import com.codegym.pms.service.CategoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService {
    public static Map<Integer, Category> categories;

    static{
        categories = new HashMap<>();
        categories.put(10, new Category(10, "other"));
        categories.put(1, new Category(1, "smartphone"));
        categories.put(2, new Category(2, "laptop"));
        categories.put(3, new Category(3, "electronic"));
    }
    @Override
    public Category findCategoryById(int id) {
        return categories.get(id);
    }
    @Override
    public List<Category> findAllCategory() {
        return new ArrayList<>(categories.values());
    }
}
