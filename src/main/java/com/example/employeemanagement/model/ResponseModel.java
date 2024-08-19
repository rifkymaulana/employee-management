package com.example.employeemanagement.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
public class ResponseModel {
    private boolean isSuccess;
    private String status;
    private int code;
    private String message;
    private Object data;
}
