package com.codegym.pms.service;

import com.codegym.pms.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    Category findCategoryById(int id);

}
