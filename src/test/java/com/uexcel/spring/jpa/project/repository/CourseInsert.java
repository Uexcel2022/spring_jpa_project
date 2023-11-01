package com.uexcel.spring.jpa.project.repository;

import org.springframework.stereotype.Component;

import com.uexcel.spring.jpa.project.entity.Course;

@Component
public class CourseInsert {

    public Course insertCourse(String title, int credit) {

        Course courses = Course.builder()
                .credit(credit)
                .title(title)
                .build();
        return courses;
    }
}
