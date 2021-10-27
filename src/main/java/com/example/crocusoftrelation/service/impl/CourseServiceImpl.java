package com.example.crocusoftrelation.service.impl;

import com.example.crocusoftrelation.dao.entity.Course;
import com.example.crocusoftrelation.dao.repo.CourseRepo;
import com.example.crocusoftrelation.dto.request.CourseRequestDto;
import com.example.crocusoftrelation.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;
    @Override
    public String saveCourse(CourseRequestDto request) {

        Course map = modelMapper.map(request, Course.class);

        courseRepo.save(map);

        return "Course Saved";
    }
}
