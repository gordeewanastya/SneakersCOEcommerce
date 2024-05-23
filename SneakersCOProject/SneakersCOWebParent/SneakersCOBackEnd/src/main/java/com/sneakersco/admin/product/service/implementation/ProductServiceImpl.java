package com.sneakersco.admin.product.service.implementation;

import com.sneakersco.admin.product.repository.ProductRepository;
import com.sneakersco.admin.product.service.ProductService;
import com.sneakersco.common.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> listAll() {
        return (List<Product>) repo.findAll();
    }
}
