package com.ironhack.lab_springboot_postman.controllers;


import com.ironhack.lab_springboot_postman.models.Department;
import com.ironhack.lab_springboot_postman.models.Employee;
import com.ironhack.lab_springboot_postman.models.Patient;
import com.ironhack.lab_springboot_postman.repositories.EmployeeRepository;
import com.ironhack.lab_springboot_postman.repositories.PatientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    PatientRespository patientRepository;
    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient findById(@PathVariable("id") int id) {
        Optional<Patient> optional = patientRepository.findById(id);
        return optional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
    }


    //Filtrar por fechas
    //patients?startDate=1970-01-01&endDate=1990-12-31.
    // Convertir las fechas a tipo LocalDate para poder comparar.
    // Usar @RequestParam para recibir los rangos como query parameters
    //TODO metodo en repo para buscar en ese rango de fechas
    @GetMapping("/patients/by-range-date")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);

            if (start.isAfter(end)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "startDate must be before endDate");
            }
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use YYYY-MM-DD.");
        }
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);

    }

    //8. Obtención de los pacientes  por departamento del médico. ej: Todos los pacientes de cardiologia
    // A través del id de empleado(medico) muestra los pacientes que han sido admitidos por ese medico

    @GetMapping("/patients/admit-employee/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDepartment(@PathVariable("employeeId") int employeeId) {
        Employee employee= employeeRepository.findByEmployeeId(employeeId);
        if (employee == null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");}


        return patientRepository.getPatientByAdmittedBy_(employee);


    }

    ;


}
