package com.example.crocusoftrelation.service.impl;

import com.example.crocusoftrelation.dao.entity.Course;
import com.example.crocusoftrelation.dao.entity.Student;
import com.example.crocusoftrelation.dao.repo.CourseRepo;
import com.example.crocusoftrelation.dao.repo.StudentRepo;
import com.example.crocusoftrelation.dto.request.CourseRequestDto;
import com.example.crocusoftrelation.exception.CustomNotFoundException;
import com.example.crocusoftrelation.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    @Override
    public String saveCourse(CourseRequestDto request) {

        if (request.getId()!=null || request.getId()!=0)
            throw new CustomNotFoundException("The id of the course must be 0 or null");

        Course map = modelMapper.map(request, Course.class);

        for (Long item : request.getStudents()) {
            if (item!=0 || item!=null) {
                var student = studentRepo.findById(item).get();
                map.getStudents().add(student);
            }
        }

        courseRepo.save(map);

        return "Course Saved";
    }

    @Override
    public String updateCourse(CourseRequestDto request) {

        if (request.getId()==null || request.getId()==0)
            throw new CustomNotFoundException("The id of the course must be 0 or null");

        Course map = modelMapper.map(request, Course.class);

        for (Long item : request.getStudents()) {
            Student student = studentRepo.findById(item).orElseThrow(() -> new CustomNotFoundException("Student id does not exist"));
            map.getStudents().add(student);
        }

        courseRepo.save(map);

        return "Course Updated";
    }
}
