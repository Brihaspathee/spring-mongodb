package com.example.springmongodb.bootstrap;

import com.example.springmongodb.domain.entity.Address;
import com.example.springmongodb.domain.entity.Gender;
import com.example.springmongodb.domain.entity.Student;
import com.example.springmongodb.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, June 2022
 * Time: 4:47 PM
 * Project: spring-mongodb
 * Package Name: com.example.springmongodb.bootstrap
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        String email = "jahmed@gmail.com";
        Student student = Student.builder()
                .firstName("Jamila")
                .lastName("Ahmed")
                .email(email)
                .gender(Gender.FEMALE)
                .address(Address.builder()
                        .addressLine1("123 Main Street")
                        .city("Reading")
                        .postalCode("76343")
                        .country("USA")
                        .build())
                .favoriteSubjects(List.of("Computer Science", "Electrical Engineering"))
                .totalSpentInBooks(BigDecimal.TEN)
                .createdDate(LocalDateTime.now())
                .build();
//        Query query = new Query();
//        query.addCriteria(Criteria.where("email").is(email));
        List<Student> students = studentRepository.findAllByEmail(email);
        log.info("Students size:{}", students.size());
        if(students.size() > 1){
            throw new IllegalStateException("found many students with email " + email);
        }
        if(students.isEmpty()){
            log.info("Inserting student:{}", student);
            studentRepository.insert(student);
        }else{
            log.info(student + " already exists");
        }

    }
}
