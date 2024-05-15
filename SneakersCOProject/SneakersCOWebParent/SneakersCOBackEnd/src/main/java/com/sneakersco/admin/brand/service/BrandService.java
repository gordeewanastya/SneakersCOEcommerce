package com.sneakersco.admin.brand.service;

import com.sneakersco.admin.brand.exception.BrandNotFoundException;
import com.sneakersco.common.entity.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> listAll();
    public Brand save(Brand brand);
    public Brand get(Integer id) throws BrandNotFoundException;
    public void delete(Integer id) throws BrandNotFoundException;
}
