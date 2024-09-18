package com.example.HospitalMngbcd.Services;
import com.example.HospitalMngbcd.Entities.MedicalRecordEntity;
import com.example.HospitalMngbcd.Models.MedicalRecord;
import com.example.HospitalMngbcd.Repository.MedicalRecordRepository;
import com.example.HospitalMngbcd.exceptionHandler.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecordImpl implements MedicalRecordService{

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public String createRecord(MedicalRecord medicalRecord) {
        MedicalRecordEntity medicalRecordEntity=new MedicalRecordEntity();
        BeanUtils.copyProperties(medicalRecord,medicalRecordEntity);
        medicalRecordRepository.save(medicalRecordEntity);

        return "Record Created Successfully";
    }

    @Override
    public List<MedicalRecord> getAllRecords() {
        List<MedicalRecordEntity> medicalRecordEntities=medicalRecordRepository.findAll() ;
        if(medicalRecordEntities.isEmpty()){
            throw new ResourceNotFoundException("No medical records found");
        }
        List<MedicalRecord> medicalRecords=new ArrayList<>();
        for (MedicalRecordEntity medicalRecord:medicalRecordEntities){
            MedicalRecord medicalRecord1=new MedicalRecord();
            BeanUtils.copyProperties(medicalRecord,medicalRecord1);
            medicalRecords.add(medicalRecord1);
        }
        return medicalRecords;
    }

    @Override
    public MedicalRecord getRecordById(Long id) {
        MedicalRecordEntity medicalRecordEntity=medicalRecordRepository.findById(id)

                .orElseThrow(()->new ResourceNotFoundException("No such medical record exists"));
        MedicalRecord medicalRecord=new MedicalRecord();
        BeanUtils.copyProperties(medicalRecordEntity,medicalRecord);
        return medicalRecord;
    }

    @Override
    public String updateRecord(Long id,MedicalRecord medicalRecord) {
        MedicalRecordEntity existingmedicalRecord=medicalRecordRepository.findById(id)

                .orElseThrow(()->new ResourceNotFoundException("No such medical record exists"));
        existingmedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
        existingmedicalRecord.setNotes(medicalRecord.getNotes());
        existingmedicalRecord.setTreatment(medicalRecord.getTreatment());
        existingmedicalRecord.setPatientName(medicalRecord.getPatientName());
        existingmedicalRecord.setDoctorName(medicalRecord.getDoctorName());
        medicalRecordRepository.save(existingmedicalRecord);
        return "Record Updated Successfully";
    }

    @Override
    public String deleteRecord(Long id) {
        MedicalRecordEntity medicalRecordEntity=medicalRecordRepository.findById(id)

                .orElseThrow(()->new ResourceNotFoundException("No such medical record exists"));
        medicalRecordRepository.delete(medicalRecordEntity);
        return "Record Deleted Successfully";
    }
}
