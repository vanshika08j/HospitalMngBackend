package com.example.HospitalMngbcd.Entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2,message = "Name should have at least 2 characters")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<DoctorEntity> doctorSet;
}
