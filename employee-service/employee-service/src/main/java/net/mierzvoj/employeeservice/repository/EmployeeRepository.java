package net.mierzvoj.employeeservice.repository;

import net.mierzvoj.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
