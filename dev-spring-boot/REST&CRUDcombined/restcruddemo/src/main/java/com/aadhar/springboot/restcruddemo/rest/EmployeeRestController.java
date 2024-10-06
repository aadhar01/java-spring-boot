package com.aadhar.springboot.restcruddemo.rest;

import com.aadhar.springboot.restcruddemo.dao.EmployeeDAO;
import com.aadhar.springboot.restcruddemo.entity.Employee;
import com.aadhar.springboot.restcruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //quick and dirty injecting DAO directly instead through Service
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose endpoint for the employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }



}
