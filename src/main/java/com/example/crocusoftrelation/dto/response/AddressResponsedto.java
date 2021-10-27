package com.example.crocusoftrelation.dto.response;

import com.example.crocusoftrelation.dao.entity.Student;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressResponsedto {


    String permanent;
    String temporary;

    Student student;
}
