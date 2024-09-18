package com.example.HospitalMngbcd.Controllers;
import com.example.HospitalMngbcd.Models.MedicalRecord;
import com.example.HospitalMngbcd.Services.MedicalRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Frontend URL
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/records")
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.getAllRecords();
    }

    @GetMapping("/records/{id}")
    public MedicalRecord getRecById(@PathVariable Long id){
        return medicalRecordService.getRecordById(id);
    }

    @PostMapping("/records")
    public String createRec(@Valid @RequestBody MedicalRecord medicalRecord){
        return medicalRecordService.createRecord(medicalRecord);
    }
    @PutMapping("/records/{id}")
    public String updateRec(@PathVariable Long id,@RequestBody MedicalRecord medicalRecord){
        return medicalRecordService.updateRecord(id,medicalRecord);
    }
    @DeleteMapping("/records/{id}")
    public String deleteRec(@PathVariable Long id){
        return medicalRecordService.deleteRecord(id);
    }
}

