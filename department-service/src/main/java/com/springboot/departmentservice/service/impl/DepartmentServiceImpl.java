package com.springboot.departmentservice.service.impl;

import com.springboot.departmentservice.dto.DepartmentDTO;
import com.springboot.departmentservice.entity.Department;
import com.springboot.departmentservice.repository.DepartmentRepository;
import com.springboot.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode()
        );
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDTO departmentDTO1 = new DepartmentDTO(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
        return departmentDTO1;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String dep_ID) {
        System.out.println(dep_ID);
      Department department = departmentRepository.findByDepartmentCodeEquals(dep_ID);
      System.out.println("ffff : "+department.getDepartmentName());
      DepartmentDTO departmentDTO = new DepartmentDTO(
              department.getId(),
              department.getDepartmentName(),
              department.getDepartmentDescription(),
              department.getDepartmentCode()
      );

        return departmentDTO;
    }
}
