package com.uexcel.spring.jpa.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uexcel.spring.jpa.project.entity.Teacher;

@Repository
interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT s.teacherId FROM Teacher s WHERE s.firstName = ?1 AND s.lastName = ?2")
    public Long fetchTeacherId(String firstName, String LastName);
}
