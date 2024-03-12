package com.sneakersco.admin.user.service.implementation;

import com.sneakersco.admin.user.exception.UserNotFoundException;
import com.sneakersco.admin.user.repository.RoleRepository;
import com.sneakersco.admin.user.repository.UserRepository;
import com.sneakersco.admin.user.service.UserService;
import com.sneakersco.common.entity.Role;
import com.sneakersco.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
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
        return (List<Role>) roleRepo.findAll();
    }

    @Override
    public void save(User user) {
        boolean isUpdatingUser = (user.getId() != null);

        if (isUpdatingUser){
            User existingUser = userRepo.findById(user.getId()).get();

            if (user.getPassword().isEmpty()){
                user.setPassword(existingUser.getPassword());
            } else {
                encodePassword(user);
            }
        } else{
            encodePassword(user);
        }

        userRepo.save(user);
    }

    @Override
    public boolean isEmailUnique(String email, Integer id) {
        User userByEmail = userRepo.getUserByEmail(email);

        if (userByEmail == null) return true;

        boolean isCreatingNew = (id == null);

        if (isCreatingNew){
           if (userByEmail != null) return false;
        } else {
            if (userByEmail.getId() != id){
                return false;
            }
        }

        return true;
    }

    @Override
    public User get(Integer id) throws UserNotFoundException {
        try {
            return userRepo.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new UserNotFoundException("Could not find any user with ID " + id);
        }
    }

    @Override
    public void delete(Integer id) throws UserNotFoundException {
        Long countById = userRepo.countById(id);
        if (countById == null || countById == 0){
            throw new UserNotFoundException("Could not find any user with ID " + id);
        }

        userRepo.deleteById(id);
    }

    @Override
    public void updateUserEnabledStatus(Integer id, boolean enabled) {
        userRepo.updateEnabledStatus(id,enabled);
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
