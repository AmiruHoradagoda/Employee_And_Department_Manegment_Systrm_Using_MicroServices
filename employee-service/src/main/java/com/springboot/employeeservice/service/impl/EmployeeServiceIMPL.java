package com.springboot.employeeservice.service.impl;

import com.springboot.employeeservice.dto.ApiResponseDto;
import com.springboot.employeeservice.dto.DepartmentDTO;
import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.entity.Employee;
import com.springboot.employeeservice.repository.EmployeeRepository;
import com.springboot.employeeservice.service.ApiClient;
import com.springboot.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApiClient apiClient;

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
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getDepartmentCode()

            );

        DepartmentDTO departmentDTO = apiClient.getDepartment(employee.getDepartmentCode());

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDTO(employeeDTO);
        apiResponseDto.setDepartmentDTO(departmentDTO);
        return apiResponseDto;
    }

}
