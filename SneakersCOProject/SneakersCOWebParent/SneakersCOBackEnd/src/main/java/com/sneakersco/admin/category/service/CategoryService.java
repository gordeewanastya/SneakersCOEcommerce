package com.sneakersco.admin.category.service;

import com.sneakersco.admin.category.exception.CategoryNotFoundException;
import com.sneakersco.common.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> listAll();

    public List<Category> listCategoriesUsedInForm();

    Category save(Category category);

    public void updateCategoryEnabledStatus(Integer id, boolean enabled);

    public Category get(Integer id) throws CategoryNotFoundException;
    public void delete(Integer id) throws CategoryNotFoundException;
}
