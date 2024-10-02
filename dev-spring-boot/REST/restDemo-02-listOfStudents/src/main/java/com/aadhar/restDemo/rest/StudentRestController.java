package com.aadhar.restDemo.rest;

import com.aadhar.restDemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //add code for Rest students endpoint to get list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Aadhar", "Bansal"));
        students.add(new Student("Ishan", "Gupta"));
        students.add(new Student("Moksha", "Gupta"));
        return students;
    }
}
