package com.wmbanking.ms.Application.repository;

import com.wmbanking.ms.Application.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
