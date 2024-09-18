package com.example.HospitalMngbcd.Controllers;

import com.example.HospitalMngbcd.Models.Doctor;
import com.example.HospitalMngbcd.Services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Frontend URL
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List<Doctor> getDocs(){
        return doctorService.getAllDoctors();
    }

    @PostMapping("/doctors")
    public String registerDoctor(@Valid @RequestBody Doctor doctor){
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoc(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/doctors/{id}")
    public String updateDoc(@PathVariable Long id,@RequestBody Doctor doctor){
        return doctorService.updateDoctor(id,doctor);
    }

    @DeleteMapping("/doctors/{id}")
    public String deleteDoc(@PathVariable Long id){
        return doctorService.deleteDoctor(id);
    }

}

