package com.example.crocusoftrelation.service;

import com.example.crocusoftrelation.dto.request.CourseRequestDto;
import com.example.crocusoftrelation.dto.response.CourseResponsedto;

import java.util.List;

public interface CourseService {

    String saveCourse(CourseRequestDto request);

    String updateCourse(Long id,CourseRequestDto request);

    CourseResponsedto findCourseById(Long id);

    List<CourseResponsedto> findCoursesByStudentId(Long id);
    List<CourseResponsedto>  findAll();

}
