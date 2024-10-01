package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

     Student findById(Integer id);

     List<Student> findByLastName(String theLastName);

     List<Student> findAll();

     void updateLastNameById(Integer id, String newLastName);

     int updateAllLastName(String lastName);

     void deleteById(Integer id);

     void deleteAllByLastName(String lastName);
}
