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

    @Override
    public Employee save(Employee theEmployee) {

        //merge do save or update depending on the ID of the entity, if id = 0 add new, otherwise update

        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        Employee employee = findById(theId);
        entityManager.remove(employee);

    }


}
