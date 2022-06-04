package com.example.springmongodb.web.resource;

import com.example.springmongodb.services.StudentService;
import com.example.springmongodb.web.model.StudentList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, June 2022
 * Time: 5:19 PM
 * Project: spring-mongodb
 * Package Name: com.example.springmongodb.web.resource
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentResource {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<StudentList> fetchAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }
}
