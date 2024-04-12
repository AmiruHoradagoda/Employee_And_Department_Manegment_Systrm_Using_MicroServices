package com.springboot.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponseDto {
    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;
}



