package com.example.employeemanagement.dto.employee;

import com.example.employeemanagement.enums.GenderEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeDTO {

    @NotBlank(message = "NIK is mandatory")
    private Long nik;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Birth date is mandatory")
    private Date birthDate;

    @NotBlank(message = "Gender is mandatory")
    private GenderEnum gender;

    @NotBlank(message = "Hire date is mandatory")
    private Date hireDate;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    @NotBlank(message = "Created by is mandatory")
    private String createdBy;
}
