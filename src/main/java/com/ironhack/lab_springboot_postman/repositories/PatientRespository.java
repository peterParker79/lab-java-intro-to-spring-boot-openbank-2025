package com.ironhack.lab_springboot_postman.repositories;

import com.ironhack.lab_springboot_postman.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRespository extends JpaRepository<Patient, Integer> {
}
