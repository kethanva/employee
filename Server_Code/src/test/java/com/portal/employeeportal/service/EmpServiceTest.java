package com.portal.employeeportal.service;

import com.portal.employeeportal.model.Employee;
import com.portal.employeeportal.repository.EmployeeRepository;
import com.portal.employeeportal.service.EmployeeService;
import com.portal.employeeportal.service.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceTest {

    @Mock
    EmployeeRepository empRepo;

    @InjectMocks
    EmployeeServiceImpl empSer;

    Employee employee;
    Employee employee2;


    @Before
    public void setUp() {
        employee = new Employee();
        employee.setDepartment("employee_department");
        employee.setFirstName("employee_firstname");
        employee.setLastName("employee_lastname");
        employee.setDob("22/2/2001");
        employee.setGender("male");

        employee2 = new Employee();
        employee.setDepartment("employee2_department");
        employee.setFirstName("employee2_firstname");
        employee.setLastName("employee2_lastname");
        employee.setDob("22/2/2002");
        employee.setGender("female");
    }

    @Test
    public void saveEmployee() {
        //when
        Mockito.when(empRepo.save(employee)).thenReturn(employee);
        empSer.create(employee);
        Mockito.verify(empRepo, Mockito.times(1)).save(employee);

    }

    @Test
    public void saveMultiEmployees() {
        Mockito.when(empRepo.save(employee)).thenReturn(employee);
        Mockito.when(empRepo.save(employee2)).thenReturn(employee2);

        empSer.create(employee);
        empSer.create(employee2);
        Mockito.verify(empRepo, Mockito.times(1)).save(employee);
        Mockito.verify(empRepo, Mockito.times(1)).save(employee2);


    }

    @Test
    public void findAll() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Mockito.when(empRepo.findAll()).thenReturn(employees);

        ArrayList<Employee> returned = (ArrayList<Employee>) empSer.findAll();

        ArgumentCaptor<Sort> sortArgument = ArgumentCaptor.forClass(Sort.class);
        Mockito.verify(empRepo, Mockito.times(1)).findAll();

        Mockito.verifyNoMoreInteractions(empRepo);

        Assert.assertTrue(employees.equals(returned));
    }

}