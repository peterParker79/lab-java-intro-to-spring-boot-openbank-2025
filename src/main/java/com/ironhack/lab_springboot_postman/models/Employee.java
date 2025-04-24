package com.ironhack.lab_springboot_postman.models;


import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private int employeeId;

    @Enumerated(EnumType.STRING)
    Department department;

    String name;

    @Enumerated(EnumType.STRING)
    Status status;

    public Employee() {
    }

    public Employee(int employeeId, Department department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department=" + department +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
