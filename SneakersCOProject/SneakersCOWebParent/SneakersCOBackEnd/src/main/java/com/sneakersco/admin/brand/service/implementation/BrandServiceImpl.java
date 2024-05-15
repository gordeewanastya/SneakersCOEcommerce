package com.sneakersco.admin.brand.service.implementation;

import com.sneakersco.admin.brand.exception.BrandNotFoundException;
import com.sneakersco.admin.brand.repository.BrandRepository;
import com.sneakersco.admin.brand.service.BrandService;
import com.sneakersco.common.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository repo;

    @Override
    public List<Brand> listAll() {
        return (List<Brand>) repo.findAll();
    }

    @Override
    public Brand save(Brand brand) {
        return repo.save(brand);
    }

    @Override
    public Brand get(Integer id) throws BrandNotFoundException {
        try {
            return repo.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new BrandNotFoundException("Could not find any brand with ID " + id);
        }
    }

    @Override
    public void delete(Integer id) throws BrandNotFoundException {
        Long countById = repo.countById(id);

        if (countById == null || countById == 0) {
            throw new BrandNotFoundException("Could not find any brand with ID " + id);
        }

        repo.deleteById(id);
    }
}
