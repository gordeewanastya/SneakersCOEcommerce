package com.sneakersco.admin.user.service.implementation;

import com.sneakersco.admin.user.repository.RoleRepository;
import com.sneakersco.admin.user.repository.UserRepository;
import com.sneakersco.admin.user.service.UserService;
import com.sneakersco.common.entity.Role;
import com.sneakersco.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public List<Role> listRoles() {
        return (List<Role>)roleRepo.findAll();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }
}
