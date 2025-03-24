package net.mierzvoj.departmentservice.service;

import net.mierzvoj.departmentservice.dto.DepartmentDto;
import net.mierzvoj.departmentservice.entity.Department;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);
}
