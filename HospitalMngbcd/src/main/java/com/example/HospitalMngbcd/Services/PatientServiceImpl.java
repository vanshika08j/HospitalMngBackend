package com.example.HospitalMngbcd.Services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalMngbcd.Entities.PatientEntity;
import com.example.HospitalMngbcd.Models.Patient;
import com.example.HospitalMngbcd.Repository.PatientRepository;
import com.example.HospitalMngbcd.exceptionHandler.ResourceNotFoundException;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public String createPatient(Patient patient) {
        PatientEntity patientEntity=new PatientEntity();
        BeanUtils.copyProperties(patient,patientEntity);
        patientRepository.save(patientEntity);
        return "Patient registered Sucessfully!";
    }

    @Override
    public List<Patient> getAllPatients() {
        List<PatientEntity> patientEntities=patientRepository.findAll();
        if(patientEntities.isEmpty())
        {
            throw new ResourceNotFoundException("No patients found.");
        }
        List<Patient> patients=new ArrayList<>();
        for(PatientEntity patientEntity:patientEntities){
            Patient patient=new Patient();
            BeanUtils.copyProperties(patientEntity,patient);
            patients.add(patient);
        }


        return patients;
    }

    @Override
    public Patient getPatientByID(Long id) {
        PatientEntity patientEntity=patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found for this id:"+id));
        Patient patient=new Patient();
        BeanUtils.copyProperties(patientEntity,patient);
        return patient;
    }

    @Override
    public String updatePatient(Long id, Patient patient) {
        PatientEntity existingPatient=patientRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Patient not found for this idd"+id));


        existingPatient.setAddress(patient.getAddress());
        existingPatient.setName(patient.getName());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setAge(patient.getAge());


        patientRepository.save(existingPatient);
        return "Patient Updated Successfully";
    }

    @Override
    public String deletePatient(Long id) {
        PatientEntity patientEntity=patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found for this id:"+id));
        patientRepository.delete(patientEntity);
        return "Patient Deleted Successfully";
    }
}
