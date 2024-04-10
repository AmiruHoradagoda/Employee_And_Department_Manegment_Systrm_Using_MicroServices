package com.springboot.employeeservice.service.impl;

import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.entity.Employee;
import com.springboot.employeeservice.repository.EmployeeRepository;
import com.springboot.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO saveEmplyee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
        Employee saveEmployee = employeeRepository.save(employee);
        EmployeeDTO saveEmployeeDTO = new EmployeeDTO(
                saveEmployee.getId(),
                saveEmployee.getFirstName(),
                saveEmployee.getLastName(),
                saveEmployee.getEmail()
        );
        return saveEmployeeDTO;
    }

    @Override
    public EmployeeDTO getEmployeeByCode(Long id) {
        if (employeeRepository.existsById(id)) {
            Employee employee = employeeRepository.findById(id).get();
            EmployeeDTO FoundEmployeeDTO = new EmployeeDTO(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail()
            );
            return FoundEmployeeDTO ;
        }
        else {
           throw  new RuntimeException("Not Found");
        }

    }
}
