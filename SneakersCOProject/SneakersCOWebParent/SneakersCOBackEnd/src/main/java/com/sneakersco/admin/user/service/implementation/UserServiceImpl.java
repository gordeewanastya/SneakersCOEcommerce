package com.sneakersco.admin.user.service.implementation;

import com.sneakersco.admin.user.repository.RoleRepository;
import com.sneakersco.admin.user.repository.UserRepository;
import com.sneakersco.admin.user.service.UserService;
import com.sneakersco.common.entity.Role;
import com.sneakersco.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        encodePassword(user);
        userRepo.save(user);
    }

    @Override
    public boolean isEmailUnique(String email) {
        User userByEmail = userRepo.getUserByEmail(email);

        return userByEmail == null;
    }

    private void encodePassword(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
