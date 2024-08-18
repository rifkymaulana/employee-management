package com.example.employeemanagement.model;

import lombok.*;

@Data
@AllArgsConstructor
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
