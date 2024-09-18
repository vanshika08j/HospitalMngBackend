package com.example.HospitalMngbcd.Controllers;

import com.example.HospitalMngbcd.Models.Department;
import com.example.HospitalMngbcd.Services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Frontend URL
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/depts")
    public List<Department> getAllDepts(){
        return departmentService.getAllDepts();
    }
    @GetMapping("/depts/{id}")
    public Department getDeptById(@PathVariable Long id){
        return departmentService.getDeptById(id);
    }
    @PostMapping("/depts")
    public String addDept(@Valid @RequestBody Department department){
        return departmentService.createDepartment(department);
    }


    @PutMapping("/depts/{id}")
    public String updateDept(@PathVariable Long id,@RequestBody Department department){
        return departmentService.updateDept(id,department);
    }

    @DeleteMapping("/depts/{id}")
    public String deleteDept(@PathVariable Long id){
        return departmentService.deleteDept(id);
    }

}
