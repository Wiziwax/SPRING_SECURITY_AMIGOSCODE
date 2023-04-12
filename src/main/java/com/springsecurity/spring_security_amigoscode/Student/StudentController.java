package com.springsecurity.spring_security_amigoscode.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS= Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Ana Jones"),
            new Student(3, "Steve Rogers"),
            new Student(4, "Natasha Romanoff"),
            new Student(5, "T'Challa"),
            new Student(6, "Clint"),
            new Student(7, "Wanda Maximoff"),
            new Student(7, "Bruce Banner"),
            new Student(8, "Tony Stark")
    );

    //Go and learn how to use JAVA STREAMS
    @GetMapping(path="{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student" + studentId + "does not exist"));
    }
}
