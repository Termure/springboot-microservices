package net.springboot.employee_microservice.repository;

import net.springboot.employee_microservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
