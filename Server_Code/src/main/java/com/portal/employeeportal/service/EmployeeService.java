package com.portal.employeeportal.service;

import com.portal.employeeportal.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);

    List<Employee> findAll();

}
