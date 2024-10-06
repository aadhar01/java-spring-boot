package com.aadhar.springboot.restcruddemo.service;

import com.aadhar.springboot.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);
    void deleteById(int id);
}
