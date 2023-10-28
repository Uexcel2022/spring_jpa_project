package com.uexcel.spring.jpa.project.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student", uniqueConstraints = @UniqueConstraint(name = "Unique_email", columnNames = "emailAddress"))
public class Student {

    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)

    @GeneratedValue(generator = "student_sequence", strategy = GenerationType.SEQUENCE)

    @Id
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name = "emailAddress", nullable = false)
    private String emailId;

    private String guardiaName;
    private String guardianEmail;
    private String guardianPhone;

}
