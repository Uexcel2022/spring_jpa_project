package com.uexcel.spring.jpa.project.repository;

import java.util.List;

import org.hibernate.sql.Insert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uexcel.spring.jpa.project.entity.Course;
import com.uexcel.spring.jpa.project.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Autowired
    CourseInsert courseInsert;

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void saveCourseMaterial() {

        Course course = courseInsert.insertCourse("Java", 6);

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

    @Test
    public void insertIntoCourseMaterial() {
        insertIntoCourseMaterial("www.edu/Logic", "Logic");
    }

    public void insertIntoCourseMaterial(String url, String courseTitle) {
        Long courseId = courseRepository.fetchCourseId(courseTitle);
        courseMaterialRepository.insertIntoCourseMaterial(url, courseId);
    }

}
