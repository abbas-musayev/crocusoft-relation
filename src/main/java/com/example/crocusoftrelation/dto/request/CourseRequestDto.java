package com.example.crocusoftrelation.dto.request;

import com.example.crocusoftrelation.dao.entity.Student;
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
public class CourseRequestDto {

    Long id;

    String name;

    List<Student> students;
}
