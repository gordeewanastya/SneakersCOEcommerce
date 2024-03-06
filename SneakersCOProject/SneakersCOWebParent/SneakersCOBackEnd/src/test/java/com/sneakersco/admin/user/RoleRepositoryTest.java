package com.sneakersco.admin.user;

import com.sneakersco.admin.user.repository.RoleRepository;
import com.sneakersco.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateFirstRole(){
        Role roleAdmin = new Role("Admin","manage everything");
        Role savedRole = repo.save(roleAdmin);

        assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateRestRoles(){
        Role roleSalesperson = new Role("Salesperson","manage product price," +
                "customers, shipping, orders and sales report");

        Role roleEditor = new Role("Editor","manage categories, brands" +
                "products, articles and menus");

        Role roleShipper = new Role("Shipper","view products,orders and update" +
                "the order status");

        Role roleAssistant = new Role("Assistant","manage questions and" +
                "reviews of products");

        repo.saveAll(List.of(roleSalesperson,roleEditor,roleShipper,roleAssistant));
    }
}
