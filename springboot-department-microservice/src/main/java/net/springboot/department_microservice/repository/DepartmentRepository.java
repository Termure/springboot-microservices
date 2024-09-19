package net.springboot.department_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.springboot.department_microservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    Department findDepartmentByDepartmentCode(String departmentCode);
}
