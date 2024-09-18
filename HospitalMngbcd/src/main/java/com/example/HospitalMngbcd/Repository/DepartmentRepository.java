package com.example.HospitalMngbcd.Repository;

import com.example.HospitalMngbcd.Entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
