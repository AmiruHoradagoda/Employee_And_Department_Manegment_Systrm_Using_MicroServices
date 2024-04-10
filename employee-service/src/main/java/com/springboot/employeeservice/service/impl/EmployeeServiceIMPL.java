package com.springboot.employeeservice.service.impl;

import com.springboot.employeeservice.dto.ApiResponseDto;
import com.springboot.employeeservice.dto.DepartmentDTO;
import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.entity.Employee;
import com.springboot.employeeservice.repository.EmployeeRepository;
import com.springboot.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public EmployeeDTO saveEmplyee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );
        Employee saveEmployee = employeeRepository.save(employee);
        EmployeeDTO saveEmployeeDTO = new EmployeeDTO(
                saveEmployee.getId(),
                saveEmployee.getFirstName(),
                saveEmployee.getLastName(),
                saveEmployee.getEmail(),
                saveEmployee.getDepartmentCode()
        );
        return saveEmployeeDTO;
    }

    @Override
    public ApiResponseDto getEmployeeByCode(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        ResponseEntity<DepartmentDTO>responseEntity =restTemplate.getForEntity("http://localhost:8080/api/v1/departments/getDepartmentByDeptCode/"+employee.getDepartmentCode(),
                DepartmentDTO.class);
        DepartmentDTO departmentDTO = responseEntity.getBody();
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getDepartmentCode()

            );
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDTO(employeeDTO);
        apiResponseDto.setDepartmentDTO(departmentDTO);
        return apiResponseDto;
    }

}
