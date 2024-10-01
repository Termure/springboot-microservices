package net.springboot.employee_microservice.controller;

import lombok.AllArgsConstructor;
import net.springboot.employee_microservice.dto.APIResponseDto;
import net.springboot.employee_microservice.dto.EmployeeDto;
import net.springboot.employee_microservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
}
