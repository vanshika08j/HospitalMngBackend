package com.example.HospitalMngbcd.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private Long id;

    private LocalDateTime appointmentDate;
    private String patientName;
    private String doctorName;
    private String description;
    private String status;

}
