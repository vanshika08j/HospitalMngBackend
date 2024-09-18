package com.example.HospitalMngbcd.Services;

import com.example.HospitalMngbcd.Entities.DoctorEntity;
import com.example.HospitalMngbcd.Models.Doctor;
import com.example.HospitalMngbcd.Repository.DoctorRepository;
import com.example.HospitalMngbcd.exceptionHandler.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public String createDoctor(Doctor doctor) {
        DoctorEntity doctorEntity=new DoctorEntity();
        BeanUtils.copyProperties(doctor,doctorEntity);
        doctorRepository.save(doctorEntity);
        return "Doctor Added Successfully";
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<DoctorEntity> doctorEntities=doctorRepository.findAll();
        if(doctorEntities.isEmpty()){
            throw new ResourceNotFoundException("No doctors found.");
        }
        List<Doctor> doctors=new ArrayList<>();
        for(DoctorEntity doctorEntity:doctorEntities){
            Doctor doctor=new Doctor();
            BeanUtils.copyProperties(doctorEntity,doctor);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public Doctor getDoctorById(Long id) {
        DoctorEntity doctorEntity=doctorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Doctor not found for this id:"+id));
        Doctor doctor=new Doctor();
        BeanUtils.copyProperties(doctorEntity,doctor,"id");
        return doctor;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        DoctorEntity existingdoctor=doctorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Doctor not found for this id:"+id));
        existingdoctor.setName(doctor.getName());
        existingdoctor.setEmail(doctor.getEmail());
        existingdoctor.setDepartment(doctor.getDepartment());
        existingdoctor.setPhone(doctor.getPhone());
        existingdoctor.setSpecialization(doctor.getSpecialization());
        doctorRepository.save(existingdoctor);
        return "Doctor Updated Successfully";
    }

    @Override
    public String deleteDoctor(Long id) {
        DoctorEntity doctor1=doctorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Doctor not found for this id:"+id));
        doctorRepository.delete(doctor1);
        return "Doctor Deleted Succesfully";
    }
}
