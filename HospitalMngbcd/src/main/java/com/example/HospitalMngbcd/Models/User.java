package com.example.HospitalMngbcd.Models;

import com.example.HospitalMngbcd.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Long id;

    private String username;
    private String password;
    private Role role;

}
