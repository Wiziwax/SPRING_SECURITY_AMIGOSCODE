package com.springsecurity.spring_security_amigoscode.Student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS= Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Ana Jones"),
            new Student(3, "Steve Rogers"),
            new Student(4, "Natasha Romanoff"),
            new Student(5, "T'Challa"),
            new Student(6, "Clint"),
            new Student(7, "Bruce Banner"),
            new Student(8, "Tony Stark")
    );
//
//    public static List<Student> getSTUDENTS() {
//        return STUDENTS;
//    }


    @GetMapping
    public List<Student> getAllStudent(){
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable ("studentId") Integer studentId ){
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable ("studentId") Integer studentId,
                              @RequestBody Student student){
        System.out.println(String.format("%s %s", studentId, student));
    }

}
