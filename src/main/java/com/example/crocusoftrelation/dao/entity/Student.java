package com.example.crocusoftrelation.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String surname;

    @ToString.Exclude
    @JsonBackReference
    @ManyToMany(mappedBy = "students")
    List<Course> courses;

    @ToString.Exclude
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    Address address;
}
