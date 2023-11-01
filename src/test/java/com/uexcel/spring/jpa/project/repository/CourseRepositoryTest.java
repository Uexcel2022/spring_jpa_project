package com.uexcel.spring.jpa.project.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uexcel.spring.jpa.project.entity.Course;
import com.uexcel.spring.jpa.project.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseInsert courseInsert;

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

    @Test
    public void updateCourseTeacherId() {
        Long teaherId = teacherRepository.fetchTeacherId("Nice", "Cool");

        courseRepository.updateCourseTeacherId(teaherId, "Java");
        System.out.println(teaherId);
    }

    @Test
    public void saveCoursAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Captain")
                .lastName("America")
                .build();

        Course course = Course.builder()
                .title("Act")
                .credit(8)
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }

    @Test
    public void findAllAndSorting() {

        // You can go without sorting as well by excluding sort method

        Pageable sortByTitleDescending = PageRequest.of(0, 3, Sort.by("title").ascending());

        Pageable sortByCreditAscending = PageRequest.of(1, 2, Sort.by("Credit").descending());

        Pageable sortByTitleAndCredit = PageRequest.of(0, 2, Sort.by("title").ascending().and(Sort.by("Credit")));

        List<Course> courses1 = courseRepository.findAll(sortByTitleDescending).getContent();
        System.out.println(courses1);

        List<Course> courses2 = courseRepository.findAll(sortByCreditAscending).getContent();
        System.out.println(courses2);

        List<Course> courses3 = courseRepository.findAll(sortByTitleAndCredit).getContent();
        System.out.println(courses3);

        Long totalElements = courseRepository.findAll(sortByTitleDescending).getTotalElements();
        int totalPages = courseRepository.findAll(sortByTitleDescending).getTotalPages();
        System.out.println(totalElements);
        System.out.println(totalPages);

    }

}
