package com.example.HospitalMngbcd.Repository;

import com.example.HospitalMngbcd.Entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Long> {
}
