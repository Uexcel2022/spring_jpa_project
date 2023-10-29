package com.uexcel.spring.jpa.project.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uexcel.spring.jpa.project.entity.Course;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void saveCourse() {
        Course course = Course.builder()
                .title("Python")
                .credit(3)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void printListOfCourses() {
        List<Course> course = courseRepository.findAll();
        System.out.println(course);
    }

}
