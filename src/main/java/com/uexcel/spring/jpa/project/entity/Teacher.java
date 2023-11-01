package com.uexcel.spring.jpa.project.entity;

import java.util.List;

import org.hibernate.query.sqm.FetchClauseType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@Table(name = "tbl_teacher")
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long teacherId;
    private String firstName;
    private String lastName;

    // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinColumn(name = "teacher_Id", referencedColumnName = "teacherId")
    // private List<Course> courses;
}
