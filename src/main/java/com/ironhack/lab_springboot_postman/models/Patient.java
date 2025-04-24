package com.ironhack.lab_springboot_postman.models;


import jakarta.persistence.*;

@Entity
@Table(name="patiens")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="patient_id")
    private int patientId;

    String name;

    //@Column(name="date_if_bird")
    String dateOfBirth;

    //@Column(name="admitted_by")

    @ManyToOne // muchos pacientes pueden ser atendidos por un mismo empleado
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_Id") // Clave foranea
    Employee admittedBy;



}

