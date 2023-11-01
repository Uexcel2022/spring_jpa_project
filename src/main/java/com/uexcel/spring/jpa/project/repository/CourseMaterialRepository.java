package com.uexcel.spring.jpa.project.repository;

import org.apache.commons.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uexcel.spring.jpa.project.entity.CourseMaterial;

// import jakarta.transaction.Transactional;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

    @Query(value = "INSERT INTO tbl_course_material values(Next Value for course_material_sequence, ?1, ?2)", nativeQuery = true)
    public void insertIntoCourseMaterial(@Param("url") String url,
            @Param("courseId") Long courseId);

}
