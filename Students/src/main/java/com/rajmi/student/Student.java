package com.rajmi.student;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @SequenceGenerator(name="student_id_sequence",
    sequenceName = "student_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "student_id_sequence")
    private int id;
    private String name;
    private String university;
    private String teacher;
}
