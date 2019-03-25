package com.portal.employeeportal.repository;

import com.portal.employeeportal.model.Employee;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository<Employee, Integer> {

    List<Employee> findAll();

    Employee save(Employee employee);
}
