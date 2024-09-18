package com.example.HospitalMngbcd.Services;


import com.example.HospitalMngbcd.Models.Patient;

import java.util.List;

public interface PatientService {
    String createPatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientByID(Long id);
    String updatePatient(Long id,Patient patient);
    String deletePatient(Long id);
}
