package com.example.crocusoftrelation.service;

import com.example.crocusoftrelation.dto.request.CourseRequestDto;

public interface CourseService {

    String saveCourse(CourseRequestDto request);

    String updateCourse(CourseRequestDto request);
}
