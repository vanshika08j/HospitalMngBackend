package com.example.HospitalMngbcd.Repository;

import com.example.HospitalMngbcd.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}