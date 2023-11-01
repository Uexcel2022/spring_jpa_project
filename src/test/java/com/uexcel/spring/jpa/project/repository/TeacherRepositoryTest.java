package com.uexcel.spring.jpa.project.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uexcel.spring.jpa.project.entity.Course;
import com.uexcel.spring.jpa.project.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseInsert courseInsert;

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void saveTeacherAndCourse() {

        Course courses1 = courseInsert.insertCourse("English", 6);
        Course courses2 = courseInsert.insertCourse("Maths", 3);

        Teacher teacher = Teacher.builder()
                .firstName("Nice")
                .lastName("Cool")
                // .courses(List.of(courses1, courses2))
                .build();

        teacherRepository.save(teacher);

    }

    @Test
    public void saveTeacherAndUpdateTeacherIdInCourse() {

        Teacher teacher = Teacher.builder()
                .firstName("Nice")
                .lastName("Cool")
                .build();

        teacherRepository.save(teacher);

        Long teaherId = teacherRepository.fetchTeacherId("Nice", "Cool");

        courseRepository.updateCourseTeacherId(teaherId, "Java");
        System.out.println(teaherId);

    }

}
