package com.aadhar.springboot.restcruddemo.dao;

import com.aadhar.springboot.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);


}
