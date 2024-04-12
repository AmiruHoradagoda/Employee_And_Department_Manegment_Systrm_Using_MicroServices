package com.springboot.employeeservice.service;

import com.springboot.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//http://localhost:8080/api/v1/departments/getDepartmentByDeptCode/C-001
@FeignClient(url ="http://localhost:8080",name = "DEPARTMENT-SERVICE")
public interface ApiClient {
    @GetMapping("/api/v1/departments/getDepartmentByDeptCode/{dept_code}")
    DepartmentDTO getDepartment(@PathVariable(value = "dept_code") String Dept_code);
}


