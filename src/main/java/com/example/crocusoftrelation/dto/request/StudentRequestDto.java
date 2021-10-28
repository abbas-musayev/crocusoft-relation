package com.example.crocusoftrelation.dto.request;

import com.example.crocusoftrelation.dao.entity.Address;
import com.example.crocusoftrelation.dao.entity.Course;
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
public class StudentRequestDto {

    String name;
    String surname;
    List<Long> courses;
    AddressRequestDto address;
}
