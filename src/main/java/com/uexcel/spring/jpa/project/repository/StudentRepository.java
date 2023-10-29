package com.uexcel.spring.jpa.project.repository;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uexcel.spring.jpa.project.entity.Student;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

@Repository
interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL
    @Query("SELECT e FROM Student e WHERE e.emailId = ?1")
    public Student getStudentByEmailId(String emailId);

    // JPQL
    @Query("SELECT e.firstName FROM Student e WHERE e.emailId = ?1")
    public String getStudentFirstNameByEmailId(String emailId);

    // Native query
    @Query(value = "SELECT * FROM tbl_student WHERE email_address=?1", nativeQuery = true)
    public Student getStudentFirstNameByEmailIdNative(String emailId);

    // Native query
    @Query(value = "SELECT * FROM tbl_student WHERE email_address =:emailId", nativeQuery = true)
    public Student getStudentFirstNameByEmailIdNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "Update tbl_student set first_name =:firstName WHERE email_address=:emailId", nativeQuery = true)
    int updateStudentByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);

}
