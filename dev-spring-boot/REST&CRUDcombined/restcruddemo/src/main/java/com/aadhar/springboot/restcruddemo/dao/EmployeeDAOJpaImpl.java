package com.aadhar.springboot.restcruddemo.dao;

import com.aadhar.springboot.restcruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entityManger
    private EntityManager entityManager;

    // set up for constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
        return theQuery.getResultList();

    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);

    }


}
