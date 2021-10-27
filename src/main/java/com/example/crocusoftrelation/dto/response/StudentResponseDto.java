package com.example.crocusoftrelation.dto.response;

import com.example.crocusoftrelation.dao.entity.Address;
import com.example.crocusoftrelation.dao.entity.Course;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class StudentResponseDto {

    String name;
    String surname;

    @JsonBackReference
    List<Course> courses;

    @JsonBackReference
    Address address;
}
