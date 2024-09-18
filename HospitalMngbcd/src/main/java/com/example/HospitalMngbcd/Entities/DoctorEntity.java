package com.example.HospitalMngbcd.Entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(name = "doctors")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2,message = "Name should have at least 2 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Specialisation is mandatory")
    private String specialization;

    @NotNull(message = "Phone is mandatory")
    private Long phone;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @OneToMany(mappedBy = "doctor",cascade=CascadeType.ALL,orphanRemoval = true)
    private Set<AppointmentEntity> appointments;
}

