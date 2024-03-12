package com.sneakersco.admin.user.service;

import com.sneakersco.admin.user.exception.UserNotFoundException;
import com.sneakersco.common.entity.Role;
import com.sneakersco.common.entity.User;

import java.util.List;

public interface UserService {
     List<User> listAll();
     List<Role> listRoles();
     void save(User user);
     boolean isEmailUnique(String email, Integer id);
     User get(Integer id) throws UserNotFoundException;
     void delete(Integer id) throws UserNotFoundException;
     void updateUserEnabledStatus(Integer id, boolean enabled);

}
