package com.springboot.departmentservice.service;

import com.springboot.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentByCode(String dep_ID);
}
