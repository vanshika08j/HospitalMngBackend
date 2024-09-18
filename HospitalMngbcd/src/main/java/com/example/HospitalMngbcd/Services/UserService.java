package com.example.HospitalMngbcd.Services;


import com.example.HospitalMngbcd.Models.User;

import java.util.List;

public interface UserService {


    List<User> getALLUsers();

    String createUser(User user);

    User getUserById(Long id);

    String updateUser(Long id, User user);

    String deleteUser(Long id);

}

