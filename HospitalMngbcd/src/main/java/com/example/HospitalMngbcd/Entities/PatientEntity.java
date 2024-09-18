package com.example.HospitalMngbcd.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 0, message = "Age must be a positive number")
    @Max(value = 150, message = "Age must be less than or equal to 150")
    @NotNull(message = "Age required")
    private int age;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @NotNull(message = "Phone number is mandatory")
    private Long phone;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<AppointmentEntity> appointments=new HashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedicalRecordEntity> medicalHistory = new HashSet<>();

}
