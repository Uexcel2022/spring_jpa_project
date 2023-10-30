package com.uexcel.spring.jpa.project.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
// @ToString
@ToString(exclude = "course") // use with lazy fetch type
@Table(name = "tbl_course_material")
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")

    private Long courseMaterialId;

    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // fetch = FetchType.EGGER meaning fatch the value on the other table as well
    @JoinColumn(name = "course_Id", referencedColumnName = "courseId")
    private Course course;

}
