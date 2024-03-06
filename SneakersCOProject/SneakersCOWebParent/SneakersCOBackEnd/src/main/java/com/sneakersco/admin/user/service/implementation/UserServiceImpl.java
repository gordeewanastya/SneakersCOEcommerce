package com.sneakersco.admin.user.service.implementation;

import com.sneakersco.admin.user.repository.UserRepository;
import com.sneakersco.admin.user.service.UserService;
import com.sneakersco.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }
}
