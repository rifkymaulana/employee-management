package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.employee.CreateEmployeeDTO;
import com.example.employeemanagement.dto.employee.FindByIdEmployeeDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.logic.EmployeeLogic;
import com.example.employeemanagement.model.ResponseModel;
import com.example.employeemanagement.util.LoggingUtil;
import com.example.employeemanagement.util.ResponseUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    private final EmployeeLogic employeeLogic;
    private final LoggingUtil loggingUtil;
    private final ResponseUtil responseUtil;

    public EmployeeController(EmployeeLogic employeeLogic, LoggingUtil loggingUtil, ResponseUtil responseUtil) {
        this.employeeLogic = employeeLogic;
        this.loggingUtil = loggingUtil;
        this.responseUtil = responseUtil;
    }

    @GetMapping("/findAll")
    public ResponseEntity<ResponseModel> findAll() {
        try {
            ResponseModel response = employeeLogic.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            log.error("Error occurred while fetching all employees: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<ResponseModel> findById(@Valid @RequestBody FindByIdEmployeeDTO requestBody) {
        try {
            ResponseModel response = employeeLogic.findById(requestBody.getId());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            log.error("Error occurred while fetching employee by id: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseModel> create(
            @RequestHeader Map<String, Object> headers,
            @Valid @RequestBody CreateEmployeeDTO requestBody
    ) {
        try {
            loggingUtil.startController("EmployeeController", "create", headers, requestBody);

            ResponseModel response = employeeLogic.create(requestBody);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            log.error("Error occurred while saving employee: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseModel> update(@RequestBody Employee employee) {
        try {
            ResponseModel response = employeeLogic.update(employee);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            log.error("Error occurred while updating employee: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> delete(@PathVariable String id) {
        try {
            ResponseModel response = employeeLogic.delete(Long.parseLong(id));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            log.error("Error occurred while deleting employee: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }
}
