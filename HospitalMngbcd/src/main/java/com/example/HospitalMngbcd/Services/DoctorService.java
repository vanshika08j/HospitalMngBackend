package com.example.HospitalMngbcd.Services;


import com.example.HospitalMngbcd.Models.Doctor;

import java.util.List;

public interface DoctorService {

    String createDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
    String updateDoctor(Long id,Doctor doctor);
    String deleteDoctor(Long id);

}
