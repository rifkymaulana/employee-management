package com.example.employeemanagement.entity;

import com.example.employeemanagement.dto.employee.CreateEmployeeDTO;
import com.example.employeemanagement.enums.GenderEnum;
import com.example.employeemanagement.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long nik;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private GenderEnum gender;

    @Column(nullable = false)
    private Date hireDate;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private StatusEnum status;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Boolean isDeleted;
    private Timestamp deletedAt;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Employee() {
        this.status = StatusEnum.ACTIVE;
        this.isDeleted = false;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public Employee getEmployee(CreateEmployeeDTO requestBody) {
        Employee employee = new Employee();

        employee.setNik(requestBody.getNik());
        employee.setFirstName(requestBody.getFirstName());
        employee.setLastName(requestBody.getLastName());
        employee.setBirthDate(requestBody.getBirthDate());
        employee.setGender(requestBody.getGender());
        employee.setHireDate(requestBody.getHireDate());
        employee.setEmail(requestBody.getEmail());
        employee.setPhoneNumber(requestBody.getPhoneNumber());
        employee.setCreatedBy(requestBody.getCreatedBy());

        return employee;
    }
}
