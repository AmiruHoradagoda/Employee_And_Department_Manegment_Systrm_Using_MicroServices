package com.springboot.employeeservice.controller;

import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.repository.EmployeeRepository;
import com.springboot.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDTO> saveDepartment(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO departmentDTO1 = employeeService.saveEmplyee(employeeDTO);
        return new ResponseEntity<EmployeeDTO>(departmentDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeByDeptCode/{id}")
    public ResponseEntity<EmployeeDTO> getDepartmentByDeptCode(@PathVariable(value = "id") Long ID){
        EmployeeDTO employeeDTO = employeeService.getEmployeeByCode(ID);
        return new ResponseEntity<EmployeeDTO>(employeeDTO,HttpStatus.OK);
    }
}
