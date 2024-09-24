package net.springboot.employee_microservice.service.impl;

import lombok.AllArgsConstructor;
import net.springboot.employee_microservice.dto.EmployeeDto;
import net.springboot.employee_microservice.entity.Employee;
import net.springboot.employee_microservice.exception.ResourceNotFoundException;
import net.springboot.employee_microservice.repository.EmployeeRepository;
import net.springboot.employee_microservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
