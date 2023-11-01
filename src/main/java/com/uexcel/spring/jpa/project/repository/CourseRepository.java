package com.uexcel.spring.jpa.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uexcel.spring.jpa.project.entity.Course;

import jakarta.transaction.Transactional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT s.courseId FROM Course s WHERE s.title =:title")
    public Long fetchCourseId(@Param("title") String title);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_course SET teacher_id =:teacherId WHERE title =:title", nativeQuery = true)
    int updateCourseTeacherId(@Param("teacherId") Long teacherId, @Param("title") String title);

    Page<Course> findByTitleContaining(String title, Pageable pageable);

}
