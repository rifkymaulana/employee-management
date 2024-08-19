package com.example.employeemanagement.dto.employee;

import com.example.employeemanagement.enums.GenderEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateEmployeeDTO {

    @NotBlank(message = "NIK is mandatory")
    private Long nik;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Birth date is mandatory")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$", message = "Birth date should be in dd/MM/yyyy format")
    private String birthDate;

    @NotBlank(message = "Gender is mandatory")
    private GenderEnum gender;

    @NotBlank(message = "Hire date is mandatory")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$", message = "Hire date should be in dd/MM/yyyy format")
    private String hireDate;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    @NotBlank(message = "Created by is mandatory")
    private String createdBy;
}
