package net.springboot.department_microservice.service;

import net.springboot.department_microservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartment(String code);
}
