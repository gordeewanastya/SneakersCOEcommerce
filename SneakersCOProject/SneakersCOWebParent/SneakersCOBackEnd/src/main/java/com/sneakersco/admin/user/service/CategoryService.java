package com.sneakersco.admin.user.service;

import com.sneakersco.common.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> listAll();

    public List<Category> listCategoriesUsedInForm();

    Category save(Category category);
}
