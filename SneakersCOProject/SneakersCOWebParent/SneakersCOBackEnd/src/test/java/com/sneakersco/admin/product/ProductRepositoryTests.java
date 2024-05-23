package com.sneakersco.admin.product;

import com.sneakersco.admin.product.repository.ProductRepository;
import com.sneakersco.common.entity.Brand;
import com.sneakersco.common.entity.Category;
import com.sneakersco.common.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateProduct() {
        Brand brand = entityManager.find(Brand.class, 2);
        Category category = entityManager.find(Category.class, 4);

        Product product = new Product();
        product.setName("Dr.Martens Boots");
        product.setAlias("dr_martens_boots");
        product.setShortDescription("Short description for Dr.Martens Boots");
        product.setFullDescription("Full description for Dr.Martens Boots");

        product.setBrand(brand);
        product.setCategory(category);

        product.setPrice(160);
        product.setCost(120);
        product.setEnabled(true);
        product.setInStock(true);

        product.setCreatedTime(new Date());
        product.setUpdatedTime(new Date());

        Product savedProduct = repo.save(product);

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllProducts() {
        Iterable<Product> iterableProducts = repo.findAll();

        iterableProducts.forEach(System.out::println);
    }

    @Test
    public void testGetProduct() {
        Integer id = 2;
        Product product = repo.findById(id).get();
        System.out.println(product);

        assertThat(product).isNotNull();
    }

    @Test
    public void testUpdateProduct() {
        Integer id = 1;
        Product product = repo.findById(id).get();
        product.setPrice(499);

        repo.save(product);

        Product updatedProduct = entityManager.find(Product.class, id);

        assertThat(updatedProduct.getPrice()).isEqualTo(499);
    }

    @Test
    public void testDeleteProduct() {
        Integer id = 2;
        repo.deleteById(id);

        Optional<Product> result = repo.findById(id);

        assertThat(!result.isPresent());
    }
}