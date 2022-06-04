package com.example.springmongodb.domain.repository;

import com.example.springmongodb.domain.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, June 2022
 * Time: 4:44 PM
 * Project: spring-mongodb
 * Package Name: com.example.springmongodb.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findAllByEmail(String email);
}
