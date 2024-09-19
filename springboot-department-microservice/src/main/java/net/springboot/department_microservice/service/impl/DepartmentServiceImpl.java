package net.springboot.department_microservice.service.impl;

import lombok.AllArgsConstructor;
import net.springboot.department_microservice.dto.DepartmentDto;
import net.springboot.department_microservice.entity.Department;
import net.springboot.department_microservice.repository.DepartmentRepository;
import net.springboot.department_microservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDto.class);
    }
}
