package com.aadhar.restDemo.rest;

import com.aadhar.restDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //Add @PostConstruct: this automatically loads data after the loading of Bean
    public List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Aadhar", "Bansal", 1));
        students.add(new Student("Ishan", "Gupta", 2));
        students.add(new Student("Moksha", "Gupta", 3));

    }



    //add code for Rest students endpoint to get list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;

    }

    //return data for the PathVariable
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return students.get(studentId);

    }
}
