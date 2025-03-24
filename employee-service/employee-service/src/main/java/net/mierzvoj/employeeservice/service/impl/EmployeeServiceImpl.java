package net.mierzvoj.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.mierzvoj.employeeservice.dto.APIResponseDto;
import net.mierzvoj.employeeservice.dto.DepartmentDto;
import net.mierzvoj.employeeservice.dto.EmployeeDto;
import net.mierzvoj.employeeservice.entity.Employee;
import net.mierzvoj.employeeservice.repository.EmployeeRepository;
import net.mierzvoj.employeeservice.service.APIClient;
import net.mierzvoj.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final APIClient aPIClient;
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);



        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        DepartmentDto departmentDto = aPIClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
