package com.example.HospitalMngbcd.Controllers;
import com.example.HospitalMngbcd.Models.Patient;
import com.example.HospitalMngbcd.Services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Frontend URL
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/patients")
    public String registerPatient(@Valid @RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable Long id){
        return patientService.getPatientByID(id);
    }

    @PutMapping("/patients/{id}")
    public String updatePatient(@PathVariable Long id,@RequestBody Patient patient){
        return patientService.updatePatient(id,patient);
    }

    @DeleteMapping("/patients/{id}")
    public String deletePatient(@PathVariable Long id){
        return patientService.deletePatient(id);
    }
}
