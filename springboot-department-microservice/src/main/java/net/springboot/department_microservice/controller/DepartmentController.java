package net.springboot.department_microservice.controller;

import lombok.AllArgsConstructor;
import net.springboot.department_microservice.dto.DepartmentDto;
import net.springboot.department_microservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(departmentService.saveDepartment(departmentDto));
    }
}
