package com.springboot.employeeservice.service;

import com.springboot.employeeservice.dto.ApiResponseDto;
import com.springboot.employeeservice.dto.EmployeeDTO;


public interface EmployeeService {
    EmployeeDTO saveEmplyee(EmployeeDTO employeeDTO);

    ApiResponseDto getEmployeeByCode(Long id);
}


