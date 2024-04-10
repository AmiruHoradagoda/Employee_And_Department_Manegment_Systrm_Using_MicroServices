package com.springboot.employeeservice.service;

import com.springboot.employeeservice.dto.EmployeeDTO;


public interface EmployeeService {
    EmployeeDTO saveEmplyee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeByCode(Long id);
}


