package com.example.HospitalMngbcd.Services;


import com.example.HospitalMngbcd.Models.Department;

import java.util.List;

public interface DepartmentService{
    String createDepartment(Department department);
    List<Department> getAllDepts();
    Department getDeptById(Long id);
    String updateDept(Long id,Department department);
    String deleteDept(Long id);
}
