package com.example.springmongodb.services;

import com.example.springmongodb.domain.entity.Student;
import com.example.springmongodb.domain.repository.StudentRepository;
import com.example.springmongodb.web.model.StudentList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, June 2022
 * Time: 5:21 PM
 * Project: spring-mongodb
 * Package Name: com.example.springmongodb.services
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentList findAllStudents(){
        List<Student> students = studentRepository.findAll();
        return StudentList.builder()
                .students(students)
                .build();
    }
}
