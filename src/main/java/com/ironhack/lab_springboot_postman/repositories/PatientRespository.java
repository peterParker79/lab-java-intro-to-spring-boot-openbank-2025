package com.ironhack.lab_springboot_postman.repositories;

import com.ironhack.lab_springboot_postman.models.Department;
import com.ironhack.lab_springboot_postman.models.Employee;
import com.ironhack.lab_springboot_postman.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRespository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(String startDate, String endDate);


    List<Patient> getPatientByAdmittedBy_Department(Department admittedByDepartment);

    List<Patient> getPatientByAdmittedBy_(Employee admittedBy);

    List<Patient> admittedBy(Employee admittedBy);
}
