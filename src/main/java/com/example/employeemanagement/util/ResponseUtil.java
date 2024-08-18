package com.example.employeemanagement.util;

import com.example.employeemanagement.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service("responseUtil")
public class ResponseUtil {

    public ResponseModel success(Object data) {
        return ResponseModel.builder()
                .isSuccess(true)
                .status("success")
                .code(HttpStatus.OK.value())
                .message("Request was successful")
                .data(data)
                .build();
    }

    public ResponseModel error(String message) {
        return ResponseModel.builder()
                .isSuccess(false)
                .status("error")
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(message)
                .data(new LinkedHashMap<>())
                .build();
    }

    public ResponseModel error(String message, HttpStatus httpStatus) {
        return ResponseModel.builder()
                .isSuccess(false)
                .status("error")
                .code(httpStatus.value())
                .message(message)
                .data(new LinkedHashMap<>())
                .build();
    }

    public ResponseModel error(String message, HttpStatus httpStatus, Object data) {
        return ResponseModel.builder()
                .isSuccess(false)
                .status("error")
                .code(httpStatus.value())
                .message(message)
                .data(data)
                .build();
    }
}
