package com.kimtd.service;


import com.kimtd.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee get(Integer id);

    void updateInfo(Integer id, String name);

    void  delete(Employee employee);

    void changeEmployeeInfo(Integer id, String name);

    List<Employee> findAll();

    void customerRepositoryImpl();


}
