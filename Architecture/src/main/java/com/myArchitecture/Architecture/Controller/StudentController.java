package com.myArchitecture.Architecture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myArchitecture.Architecture.Model.Student;
import com.myArchitecture.Architecture.Service.StudentServices;

//controller/StudentController.java
@RestController
@RequestMapping("/students")
public class StudentController {

 @Autowired
 private StudentServices studentService;

 @PostMapping
 public ResponseEntity<Student> addStudent(@RequestBody Student student) {
     Student saved = studentService.saveStudent(student);
     return ResponseEntity.ok(saved);
 }

 @GetMapping
 public ResponseEntity<List<Student>> getAllStudents() {
     return ResponseEntity.ok(studentService.getAllStudents());
 }
}




