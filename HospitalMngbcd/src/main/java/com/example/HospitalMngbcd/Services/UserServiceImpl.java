package com.example.HospitalMngbcd.Services;

import com.example.HospitalMngbcd.Entities.UserEntity;
import com.example.HospitalMngbcd.Models.User;
import com.example.HospitalMngbcd.Repository.UserRepository;
import com.example.HospitalMngbcd.exceptionHandler.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getALLUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        if (userEntities.isEmpty()) {
            throw new ResourceNotFoundException("No users found.");
        }
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            users.add(user);
        }
        return users;
    }

    @Override
    public String createUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return "User registered successfully!";
    }

    @Override
    public User getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + id));
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public String updateUser(Long id, User user) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + id));

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        userRepository.save(existingUser);
        return "User updated successfully!";

    }

    @Override
    public String deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + id));
        userRepository.delete(userEntity);
        return "User deleted successfully!";
    }

}



