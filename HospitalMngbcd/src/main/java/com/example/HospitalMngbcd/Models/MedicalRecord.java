package com.example.HospitalMngbcd.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MedicalRecord {
    private Long id;

    private String patientName;
    private String diagnosis;
    private String treatment;
    private String doctorName;
    private String notes;

}
