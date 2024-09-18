package com.example.HospitalMngbcd.Repository;

import com.example.HospitalMngbcd.Entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Long > {
}

