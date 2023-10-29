package com.uexcel.spring.jpa.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uexcel.spring.jpa.project.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
