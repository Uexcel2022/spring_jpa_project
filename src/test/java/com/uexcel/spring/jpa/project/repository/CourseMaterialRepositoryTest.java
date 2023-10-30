package com.uexcel.spring.jpa.project.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uexcel.spring.jpa.project.entity.Course;
import com.uexcel.spring.jpa.project.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.gks.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);

    }

    @Test
    public void printListOfCourseMaterialsAndCourse() {
        List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
        System.out.println(courseMaterial);
    }
}
