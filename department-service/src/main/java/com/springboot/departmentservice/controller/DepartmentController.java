package com.springboot.departmentservice.controller;

import com.springboot.departmentservice.dto.DepartmentDTO;
import com.springboot.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/saveDepartment")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
            DepartmentDTO departmentDTO1 = departmentService.saveDepartment(departmentDTO);
            return new ResponseEntity<DepartmentDTO>(departmentDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/getDepartmentByDeptCode/{dept_code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByDeptCode(@PathVariable(value = "dept_code") String Dept_code){
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(Dept_code);
        return new ResponseEntity<DepartmentDTO>(departmentDTO,HttpStatus.OK);
    }

}
