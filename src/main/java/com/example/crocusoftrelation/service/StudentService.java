package com.example.crocusoftrelation.service;

import com.example.crocusoftrelation.dao.entity.Student;
import com.example.crocusoftrelation.dto.request.StudentRequestDto;
import com.example.crocusoftrelation.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentService {

    String saveStudent(StudentRequestDto request);
    String updateStudent(StudentRequestDto request);
    StudentResponseDto findStudentById(Long id);
    List<StudentResponseDto> findAllStudents();
    List<StudentResponseDto> findStudentsByCourseId(Long id);


}
