package com.uexcel.spring.jpa.project.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.JdbcType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = { "teacher", "courseMaterial" })
@Table(name = "tbl_course", uniqueConstraints = @UniqueConstraint(name = "tite_unique", columnNames = "title"))
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")

    private Long courseId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)

    @JoinTable(name = "tbl_student_course_map", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"))

    private List<Student> students;

    public void addStudents(Student student) {

        if (students == null) {
            students = new ArrayList<>();
        }

        students.add(student);

    }

}
