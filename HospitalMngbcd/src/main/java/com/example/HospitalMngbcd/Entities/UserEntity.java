package com.example.HospitalMngbcd.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username is required")
    @Size(min = 2, message = "Username should have at least 2 characters")
    private String username;

    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;

    @NotNull(message = "Role is required")
    @Enumerated(EnumType.STRING)
    private Role role;


}
