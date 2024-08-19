package com.example.employeemanagement.dto.employee;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FindByIdEmployeeDTO {

    @NotBlank(message = "Id is mandatory")
    private Long id;
}
