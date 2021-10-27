package com.example.crocusoftrelation.service;

import com.example.crocusoftrelation.dao.entity.Student;
import com.example.crocusoftrelation.dto.request.CourseRequestDto;
import com.example.crocusoftrelation.dto.response.StudentResponseDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseService {

    String saveCourse(CourseRequestDto request);

    String updateCourse(CourseRequestDto request);

}
