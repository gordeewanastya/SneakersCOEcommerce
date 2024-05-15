package com.sneakersco.admin.category.repository;

import com.sneakersco.common.entity.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends CrudRepository<Category,Integer>,PagingAndSortingRepository<Category, Integer> {
    @Query("UPDATE Category c SET c.enabled = ?2 WHERE c.id = ?1")
    @Modifying
    public void updateEnabledStatus(Integer id, boolean enabled);
    public Long countById(Integer id);
}
