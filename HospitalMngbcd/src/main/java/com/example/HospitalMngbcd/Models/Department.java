package com.example.HospitalMngbcd.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long id;

    private String name;
    private String description;
    private Long doctorId; // Add this field

}
