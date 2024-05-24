package com.sneakersco.admin.brand;

import com.sneakersco.admin.brand.repository.BrandRepository;
import com.sneakersco.common.entity.Brand;
import com.sneakersco.common.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BrandRepositoryTests {
    @Autowired
    private BrandRepository repo;

    @Test
    public void testCreateBrand1() {
        Category trainers = new Category(1);
        Brand nike = new Brand("Nike");
        nike.getCategories().add(trainers);

        Brand savedBrand = repo.save(nike);

        assertThat(savedBrand).isNotNull();
        assertThat(savedBrand.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindAll(){
        Iterable<Brand> brands = repo.findAll();
        brands.forEach(System.out::println);

        assertThat(brands).isNotEmpty();
    }

    @Test
    public void testCreateBrand2() {
        Category boots = new Category(4);
        Brand drMartens = new Brand("Dr.Martens");
        drMartens.getCategories().add(boots);

        Brand savedBrand = repo.save(drMartens);
        assertThat(savedBrand).isNotNull();
        assertThat(savedBrand.getId()).isGreaterThan(0);
    }

    @Test
    public void testSetCategoriesToBrand(){
        Brand brand = repo.findById(2).get();
        Category trainers = new Category(4);
        brand.getCategories().add(trainers);

        Brand updatedBrand = repo.save(brand);
        assertThat(updatedBrand).isNotNull();
    }

}
