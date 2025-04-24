package com.ironhack.lab_springboot_postman.repositories;

import com.ironhack.lab_springboot_postman.models.Department;
import com.ironhack.lab_springboot_postman.models.Employee;
import com.ironhack.lab_springboot_postman.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmployeeId (int employeeId);

    List<Employee> findByStatus(Status status);

    List<Employee> findByDepartment(Department department);

}
