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
    //asumo que el formato es siempre YYYY-MM-DD y podemos comparar posteriormente fechas
    String dateOfBirth;

    @ManyToOne // muchos pacientes pueden ser atendidos por un mismo empleado
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_Id") // Clave foranea
    Employee admittedBy;

    public Patient() {
    }

    public Patient(int patientId, String name, String dateOfBirth, Employee admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Employee admittedBy) {
        this.admittedBy = admittedBy;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", admittedBy=" + admittedBy +
                '}';
    }
}

