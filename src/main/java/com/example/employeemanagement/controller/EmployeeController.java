package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.logic.EmployeeLogic;
import com.example.employeemanagement.model.ResponseModel;
import com.example.employeemanagement.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    private final EmployeeLogic employeeLogic;
    private final ResponseUtil responseUtil;

    public EmployeeController(EmployeeLogic employeeLogic, ResponseUtil responseUtil) {
        this.employeeLogic = employeeLogic;
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
    public ResponseEntity<ResponseModel> findById(Long id) {
        try {
            ResponseModel response = employeeLogic.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            log.error("Error occurred while fetching employee by id: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseModel> save(Employee employee) {
        try {
            ResponseModel response = employeeLogic.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            log.error("Error occurred while saving employee: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseModel> update(Employee employee) {
        try {
            ResponseModel response = employeeLogic.update(employee);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            log.error("Error occurred while updating employee: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseModel> delete(Long id) {
        try {
            ResponseModel response = employeeLogic.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            log.error("Error occurred while deleting employee: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }
}
