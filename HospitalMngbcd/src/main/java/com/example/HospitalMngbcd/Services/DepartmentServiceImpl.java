package com.example.HospitalMngbcd.Services;

import com.example.HospitalMngbcd.Entities.DepartmentEntity;
import com.example.HospitalMngbcd.Models.Department;
import com.example.HospitalMngbcd.Repository.DepartmentRepository;
import com.example.HospitalMngbcd.exceptionHandler.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public String createDepartment(Department department) {
        DepartmentEntity departmentEntity=new DepartmentEntity();
        BeanUtils.copyProperties(department,departmentEntity);
        departmentRepository.save(departmentEntity);
        return "Department Added Successfully";
    }

    @Override
    public List<Department> getAllDepts() {
        List<DepartmentEntity> departmentEntities=departmentRepository.findAll();
        if(departmentEntities.isEmpty()){
            throw new ResourceNotFoundException("Departments do not exist");
        }
        List<Department> departments=new ArrayList<>();
        for(DepartmentEntity departmentEntity:departmentEntities){
            Department department=new Department();
            BeanUtils.copyProperties(departmentEntity,department);
            departments.add(department);
        }
        return departments;
    }

    @Override
    public Department getDeptById(Long id) {
        DepartmentEntity departmentEntity=departmentRepository.findById(id)

                .orElseThrow(()->new ResourceNotFoundException("No such Department exists"));
        Department department=new Department();
        BeanUtils.copyProperties(departmentEntity,department);
        return department;
    }

    @Override
    public String updateDept(Long id, Department department) {
        DepartmentEntity existingDept=departmentRepository.findById(id)

                .orElseThrow(()->new ResourceNotFoundException("No such Department exists"));
        existingDept.setDescription(department.getDescription());
        existingDept.setName(department.getName());
        departmentRepository.save(existingDept);
        return "Department Updated Successfully";
    }

    @Override
    public String deleteDept(Long id) {
        DepartmentEntity departmentEntity=departmentRepository.findById(id)

                .orElseThrow(()->new ResourceNotFoundException("No such Department exists"));
        departmentRepository.delete(departmentEntity);

        return "Department deleted successfully";
    }
}
