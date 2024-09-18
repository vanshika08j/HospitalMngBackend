package com.example.HospitalMngbcd.Repository;

import com.example.HospitalMngbcd.Entities.MedicalRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecordEntity,Long> {
}
