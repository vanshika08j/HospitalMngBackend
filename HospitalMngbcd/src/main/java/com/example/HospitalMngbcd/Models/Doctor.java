package com.example.HospitalMngbcd.Models;

import com.example.HospitalMngbcd.Entities.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private Long id;
    private String name;
    private String email;
    private String specialization;
    private Long phone;
    private DepartmentEntity department;

}
