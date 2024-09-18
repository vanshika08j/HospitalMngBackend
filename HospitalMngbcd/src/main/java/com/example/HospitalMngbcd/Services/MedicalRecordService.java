package com.example.HospitalMngbcd.Services;

import com.example.HospitalMngbcd.Models.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    String createRecord(MedicalRecord medicalRecord);
    List<MedicalRecord> getAllRecords();
    MedicalRecord getRecordById(Long id);
    String updateRecord(Long id,MedicalRecord medicalRecord);
    String deleteRecord(Long id);

}
