package net.springboot.employee_microservice.service;

import net.springboot.employee_microservice.dto.APIResponseDto;
import net.springboot.employee_microservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
}
