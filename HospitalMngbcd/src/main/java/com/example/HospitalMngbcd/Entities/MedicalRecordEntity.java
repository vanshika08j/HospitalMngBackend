package com.example.HospitalMngbcd.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Medical_Records")
public class MedicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2,message = "Name should have at least 2 characters")
    private String patientName;

    @NotNull(message = "Record details are required")
    @Size(min = 5, message = "Record details should have at least 5 characters")
    private String diagnosis;

    @NotNull(message = "Record details are required")
    @Size(min = 5, message = "Record details should have at least 5 characters")
    private String treatment;

    @NotBlank(message = "Name is required")
    @Size(min = 2,message = "Name should have at least 2 characters")
    private String doctorName;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
}
