package com.sneakersco.admin.category.service.implementation;

import com.sneakersco.admin.category.exception.CategoryNotFoundException;
import com.sneakersco.admin.category.repository.CategoryRepository;
import com.sneakersco.admin.category.service.CategoryService;
import com.sneakersco.common.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repo;

    public List<Category> listAll() {
        return (List<Category>) repo.findAll();
    }

    @Override
    public List<Category> listCategoriesUsedInForm() {
        List<Category> categoriesUsedInForm = new ArrayList<>();

        Iterable<Category> categoriesInDB = repo.findAll();

        for (Category category : categoriesInDB) {
            if (category.getParent() == null) {
                categoriesUsedInForm.add(new Category(category.getName()));

                Set<Category> children = category.getChildren();

                for (Category subCategory : children) {
                    String name = "--" + subCategory.getName();
                    categoriesUsedInForm.add(new Category(name));

                    listChildren(categoriesUsedInForm, subCategory, 1);
                }
            }
        }

        return categoriesUsedInForm;
    }

    @Override
    public Category save(Category category) {
        return repo.save(category);
    }

    private void listChildren(List<Category> categoriesUsedInForm, Category parent, int subLevel) {
        int newSubLevel = subLevel + 1;
        Set<Category> children = parent.getChildren();

        for (Category subCategory : children) {
            String name = "";
            for (int i = 0; i < newSubLevel; i++) {
                name += "--";
            }
            name += subCategory.getName();

            categoriesUsedInForm.add(new Category(name));

            listChildren(categoriesUsedInForm, subCategory, newSubLevel);
        }
    }

    @Override
    public void delete(Integer id) throws CategoryNotFoundException {
        Long countById = repo.countById(id);
        if (countById == null || countById == 0) {
            throw new CategoryNotFoundException("Could not find any category with ID " + id);
        }

        repo.deleteById(id);
    }

    @Override
    public Category get(Integer id) throws CategoryNotFoundException {
        try {
            return repo.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new CategoryNotFoundException("Could not find any category with ID " + id);
        }
    }

    @Override
    public void updateCategoryEnabledStatus(Integer id, boolean enabled) {
        repo.updateEnabledStatus(id, enabled);
    }
}
