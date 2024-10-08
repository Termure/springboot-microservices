package net.springboot.employee_microservice.service.impl;

import lombok.AllArgsConstructor;
import net.springboot.employee_microservice.dto.APIResponseDto;
import net.springboot.employee_microservice.dto.DepartmentDto;
import net.springboot.employee_microservice.dto.EmployeeDto;
import net.springboot.employee_microservice.entity.Employee;
import net.springboot.employee_microservice.exception.ResourceNotFoundException;
import net.springboot.employee_microservice.repository.EmployeeRepository;
import net.springboot.employee_microservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(modelMapper.map(employee, EmployeeDto.class));
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
