package com.example.HospitalMngbcd.Entities;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date is required")
    private LocalDateTime appointmentDate;

    @NotBlank(message = "Name is required")
    @Size(min = 2,message = "Name should have at least 2 characters")
    private String patientName;

    @NotBlank(message = "Name is required")
    @Size(min = 2,message = "Name should have at least 2 characters")
    private String doctorName;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Status is required")
    private String status;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;


}
