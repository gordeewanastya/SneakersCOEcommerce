package com.sneakersco.admin.user.repository;

import com.sneakersco.common.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends CrudRepository<Category,Integer>,PagingAndSortingRepository<Category, Integer> {
}
