package com.sneakersco.admin.user.service;

import com.sneakersco.admin.user.exception.UserNotFoundException;
import com.sneakersco.common.entity.Role;
import com.sneakersco.common.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
     List<User> listAll();
     List<Role> listRoles();
     User save(User user);
     boolean isEmailUnique(String email, Integer id);
     User get(Integer id) throws UserNotFoundException;
     void delete(Integer id) throws UserNotFoundException;
     void updateUserEnabledStatus(Integer id, boolean enabled);
     Page<User> listByPage(int pageNum,String sortField, String sortDir,String keyword);
}
