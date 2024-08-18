package com.example.employeemanagement.logic;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.model.ResponseModel;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeLogic")
@Slf4j
public class EmployeeLogic {

    private final EmployeeService employeeService;
    private final ResponseUtil responseUtil;

    public EmployeeLogic(EmployeeService employeeService, ResponseUtil responseUtil) {
        this.employeeService = employeeService;
        this.responseUtil = responseUtil;
    }

    public ResponseModel findAll() {
        try {
            List<Employee> employees = employeeService.findAll();

            return responseUtil.success(employees);
        } catch (Exception exception) {
            log.error("Error occurred while fetching all employees: {}", exception.getMessage(), exception);
            return responseUtil.error(exception.getMessage());
        }
    }

    public ResponseModel findById(Long id) {
        try {
            Employee employee = employeeService.findById(id).orElse(null);

            return responseUtil.success(employee);
        } catch (Exception exception) {
            log.error("Error occurred while fetching employee by id: {}", exception.getMessage(), exception);
            return responseUtil.error(exception.getMessage());
        }
    }

    public ResponseModel save(Employee employee) {
        try {
            Employee savedEmployee = employeeService.save(employee);

            return responseUtil.success(savedEmployee);
        } catch (Exception exception) {
            log.error("Error occurred while saving employee: {}", exception.getMessage(), exception);
            return responseUtil.error(exception.getMessage());
        }
    }

    public ResponseModel update(Employee employee) {
        try {
            Employee updatedEmployee = employeeService.update(employee);

            return responseUtil.success(updatedEmployee);
        } catch (Exception exception) {
            log.error("Error occurred while updating employee: {}", exception.getMessage(), exception);
            return responseUtil.error(exception.getMessage());
        }
    }

    public ResponseModel delete(Long id) {
        try {
            employeeService.delete(id);

            return responseUtil.success("Employee deleted successfully");
        } catch (Exception exception) {
            log.error("Error occurred while deleting employee: {}", exception.getMessage(), exception);
            return responseUtil.error(exception.getMessage());
        }
    }
}
