package com.ironhack.lab_springboot_postman.controllers;


import com.ironhack.lab_springboot_postman.models.Employee;
import com.ironhack.lab_springboot_postman.models.Status;
import com.ironhack.lab_springboot_postman.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired EmployeeRepository employeeRepository;


    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }



    @GetMapping("/employees/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeId(@PathVariable(name="id") int id) {
        return employeeRepository.findByEmployeeId(id);
    }


    @GetMapping("/employees/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesStatus(@PathVariable(name="status") String status) {
        try {
            // Convertir el String recibido a Status (ENUM)
            Status statusEnum = Status.valueOf(status.toUpperCase());
            // Llamar al repositorio con el Status convertido
            return employeeRepository.findByStatus(statusEnum);
        } catch (IllegalArgumentException e) {
            // Si el status no es válido, lanzar una excepción con código 400 (Bad Request)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status value: " + status);
        }


    }
    //public Product getProductById(@PathVariable(name="id") long productId) {
    //   return productRepository.findById(productId).get();


}
