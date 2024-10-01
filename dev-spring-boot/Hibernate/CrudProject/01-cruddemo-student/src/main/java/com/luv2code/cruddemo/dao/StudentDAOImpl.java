package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository annotation does
// 1. Component scanning
// 2. Translate JDBC exception(translating checked exceptions to uncheckedExceptions)
@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entityManger
    // inject entity Manger using constructor injection
    //implement save method

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // as we are changing the db
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery =  entityManager.createQuery(
                                    "Select s FROM Student s where s.lastName= :theData ",
                                Student.class);
        theQuery.setParameter("theData", theLastName);
        return theQuery.getResultList();

    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateLastNameById(Integer id, String newLastName) {
        Student student = entityManager.find(Student.class, id);
        student.setLastName(newLastName);
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int updateAllLastName(String lastName) {
        Query theQuery = entityManager.createQuery("UPDATE Student set lastName = :theData");
        theQuery.setParameter("theData", lastName);
        return theQuery.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Student student = entityManager.find(Student.class, id);
//        System.out.println(student);
        if (student != null)
            entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteAllByLastName(String lastName) {
        Query theQuery = entityManager.createQuery("Delete FROM Student Where lastName = :theData");
        theQuery.setParameter("theData", lastName);
        theQuery.executeUpdate();
    }
}
