package com.sneakersco.admin.user.service;

import com.sneakersco.admin.user.exception.UserNotFoundException;
import com.sneakersco.common.entity.Role;
import com.sneakersco.common.entity.User;

import java.util.List;

public interface UserService {
    public List<User> listAll();
    public List<Role> listRoles();
    public void save(User user);
    public boolean isEmailUnique(String email, Integer id);
    User get(Integer id) throws UserNotFoundException;
}
