package com.ironhack.lab_springboot_postman.repositories;

import com.ironhack.lab_springboot_postman.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRespository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(String startDate, String endDate);


}
