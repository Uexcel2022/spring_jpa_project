package com.uexcel.spring.jpa.project.repository;

import java.security.Guard;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uexcel.spring.jpa.project.entity.Guardian;
import com.uexcel.spring.jpa.project.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    // @Test
    // public void saveStudent() {

    // Student student = Student.builder()

    // .firstName("Uexcel")
    // .lastName("Excellence")
    // .emailId("uexcel@gmail.com")
    // // .guardiaName("Kelven")
    // // .guardianEmail("kelven@gmail.com")
    // // .guardianPhone("738372929282")
    // .build();

    // studentRepository.save(student);

    // }

    @Test
    protected void saveStudentWithGuardin() {
        Guardian guardian = Guardian.builder()
                .name("Michael")
                .email("michael@gmail.com")
                .phone("93039303030")
                .build();

        Student student = Student.builder()
                .firstName("Zera")
                .lastName("Eunice")
                .emailId("zeraeunice@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> student = studentRepository.findAll();
        System.out.println(student);

    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Zera");
        System.out.println(students);

    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Zer");
        System.out.println(students);
    }

    @Test
    public void printStudentByLstNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println(students);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Michael");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        List<Student> students = studentRepository.findByFirstNameAndLastName("Zera", "Eunice");
        System.out.println(students);

    }

    @Test
    public void printStudentByEmailId() {
        Student student = studentRepository.getStudentByEmailId("zeraeunice@gmail.com");
        System.out.println(student);

    }

    @Test
    public void printFirstNameStudentByEmailId() {
        String firstName = studentRepository.getStudentFirstNameByEmailId("zeraeunice@gmail.com");
        System.out.println(firstName);

    }

    @Test
    public void printFirstNameStudentByEmailIdNative() {
        Student student = studentRepository.getStudentFirstNameByEmailIdNative("zeraeunice@gmail.com");
        System.out.println(student);

    }

    @Test
    public void getStudentFirstNameByEmailIdNativeNamedParam() {
        Student student = studentRepository.getStudentFirstNameByEmailIdNativeNamedParam("zeraeunice@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentByEmailId() {
        studentRepository.updateStudentByEmailId("Zarah", "zeraeunice@gmail.com");
    }

}
