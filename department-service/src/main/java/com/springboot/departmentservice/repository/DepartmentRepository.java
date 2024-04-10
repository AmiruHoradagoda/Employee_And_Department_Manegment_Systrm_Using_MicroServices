package com.springboot.departmentservice.repository;

import com.springboot.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentCodeEquals(String department_code);
}
