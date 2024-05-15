package com.sneakersco.admin.brand.repository;

import com.sneakersco.common.entity.Brand;
import com.sneakersco.common.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrandRepository extends CrudRepository<Brand, Integer>, PagingAndSortingRepository<Brand, Integer> {
    public Long countById(Integer id);
}
