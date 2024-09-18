package com.example.HospitalMngbcd.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private Long phone;
    private String email;
    private String address;

}
