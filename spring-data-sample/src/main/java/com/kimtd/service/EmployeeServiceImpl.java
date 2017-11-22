package com.kimtd.service;

import com.kimtd.entity.Employee;
import com.kimtd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee get(Integer id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void updateInfo(Integer id, String name) {
         employeeRepository.changeEmployeeInfo(id,name);
    }

    @Override
    public void delete(Employee employee) {
            employeeRepository.delete(employee);
    }

    @Override
    public void changeEmployeeInfo(Integer id, String name) {
            employeeRepository.changeEmployeeInfo(id,name);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void customerRepositoryImpl() {
        employeeRepository.sayHello();
    }
}
