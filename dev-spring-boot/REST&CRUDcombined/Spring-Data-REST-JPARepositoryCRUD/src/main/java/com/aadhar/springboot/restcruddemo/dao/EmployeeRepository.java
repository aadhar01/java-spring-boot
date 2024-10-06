package com.aadhar.springboot.restcruddemo.dao;

import com.aadhar.springboot.restcruddemo.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //With JpaRepository we don't need to implement this interface
}
