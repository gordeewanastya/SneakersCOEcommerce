package com.sneakersco.admin.brand.repository;

import com.sneakersco.common.entity.Brand;
import com.sneakersco.common.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Integer>, PagingAndSortingRepository<Brand, Integer> {
    public Long countById(Integer id);

    @Query("SELECT NEW Brand(b.id,b.name) FROM Brand b ORDER BY b.name ASC")
    public List<Brand> findAll();
}
