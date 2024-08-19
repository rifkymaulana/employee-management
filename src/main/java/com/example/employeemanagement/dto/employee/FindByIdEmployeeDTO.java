package com.example.employeemanagement.dto.employee;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FindByIdEmployeeDTO {

    @NotBlank(message = "Id is mandatory")
    private Long id;
}
