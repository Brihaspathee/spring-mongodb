package com.example.springmongodb.web.model;

import com.example.springmongodb.domain.entity.Student;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, June 2022
 * Time: 5:20 PM
 * Project: spring-mongodb
 * Package Name: com.example.springmongodb.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentList {

    private List<Student> students;

    @Override
    public String toString() {
        return "StudentList{" +
                "students=" + students +
                '}';
    }
}
