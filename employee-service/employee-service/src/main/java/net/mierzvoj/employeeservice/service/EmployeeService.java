package net.mierzvoj.employeeservice.service;

import net.mierzvoj.employeeservice.dto.APIResponseDto;
import net.mierzvoj.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
