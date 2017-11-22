package com.kimtd.service;

import com.kimtd.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class EmployeeTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSave(){
        Employee employee = new Employee();
        employee.setAge(20);
        employee.setName("kim");
        employeeService.save(employee);
    }

    @Test
    public void testCustomerMethod(){
        employeeService.customerRepositoryImpl();
    }

    @Test
    public void testGet(){
        Employee employee = employeeService.get(2);
        System.out.println(employee);
    }

    @Test
    public void testDel(){
        Employee employee = employeeService.get(1);
        employeeService.delete(employee);
    }

}
