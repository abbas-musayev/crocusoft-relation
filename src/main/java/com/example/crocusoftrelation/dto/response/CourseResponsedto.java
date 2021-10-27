package com.example.crocusoftrelation.dto.response;

import com.example.crocusoftrelation.dao.entity.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseResponsedto {

    String name;

    @JsonBackReference
    List<Student> students;
}
